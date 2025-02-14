package br.com.fiap.postech.video_manager.domain.usecases;

import br.com.fiap.postech.video_manager.infra.repositories.bucket.FileService;
import br.com.fiap.postech.video_manager.infra.repositories.sqs.models.S3Object;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DownloadFileUseCase {

    private final FileService fileService;

    public byte[] execute(String fileName) {
        return fileService.getFileFromS3(fileName);
    }
}
