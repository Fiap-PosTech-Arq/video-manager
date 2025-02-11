package br.com.fiap.postech.video_manager.infra.repositories.sqs;


import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UpdateFileListener {

    @SqsListener("${aws.sqs.queue-url}")
    public void listen(@Payload String message) {
        System.out.println("Mensagem recebida do SQS: " + message);
    }
}
