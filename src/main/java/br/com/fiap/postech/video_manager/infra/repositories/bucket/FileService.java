package br.com.fiap.postech.video_manager.infra.repositories.bucket;

import br.com.fiap.postech.video_manager.domain.ports.FileServicePortOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
public class FileService implements FileServicePortOut {

    private final S3Client s3Client;
    private final String bucketName;

    public FileService(S3Client s3Client,
                       @Value("${aws.s3.bucketName}") String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    @Override
    public void upload(Path file) {

        try{
            var request = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(file.getFileName().toString())
                    .contentType(Files.probeContentType(file))
                    .build();
          log.info("Enviando arquivo para o bucket: {}", bucketName);
            s3Client.putObject(request, RequestBody.fromFile(file));
        }catch (IOException e) {
            log.error("Erro ao enviar o arquivo para o S3: {}", e.getMessage());
        }
    }
}
