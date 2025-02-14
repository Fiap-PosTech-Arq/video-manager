package br.com.fiap.postech.video_manager.infra.repositories.sqs;


import br.com.fiap.postech.video_manager.infra.repositories.UploadRepository;
import br.com.fiap.postech.video_manager.infra.repositories.sqs.models.S3EventNotification;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Slf4j
@Component
public class UpdateFileListener {

    private final UploadRepository repository;

    @SqsListener("${aws.sqs.queue-url}")
    public void listen(@Payload S3EventNotification eventNotification) {
        log.info("Mensagem recebida do SQS: {}", eventNotification);

        String fileName = eventNotification.getRecords().stream()
                .map(e -> e.s3().object().key())
                .map(this::removeSuffix).findFirst()
                .orElseThrow();

         var videoUploaded = repository.findByFileInName(fileName).orElseThrow();
         videoUploaded.setFileOutName(fileName + ".zip");

         repository.save(videoUploaded);
    }

    private String removeSuffix(String fileName) {
        return fileName.substring(0, fileName.indexOf(".") +1 );
    }

}
