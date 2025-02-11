package br.com.fiap.postech.video_manager.infra.repositories.sqs;


import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateFileListener {

    @SqsListener("${aws.sqs.queue-url}")
    public void listen(@Payload String message) {
        log.info("Mensagem recebida do SQS: {}", message);
    }
}
