package br.com.fiap.postech.video_manager.domain.usecases;

import br.com.fiap.postech.video_manager.domain.entities.Status;
import br.com.fiap.postech.video_manager.domain.entities.UploadModel;
import br.com.fiap.postech.video_manager.domain.entities.VideoUploadRequest;
import br.com.fiap.postech.video_manager.domain.ports.FileServicePortOut;
import br.com.fiap.postech.video_manager.domain.ports.UploadRepositoriesPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


@Slf4j
@RequiredArgsConstructor
@Component
public class UploadFileUseCase {

    private final FileServicePortOut fileService;
    private final UploadRepositoriesPortOut repository;

    public UploadModel save(VideoUploadRequest videoUploadRequest) {
        MultipartFile multipartFile = videoUploadRequest.getFile();

        var uploadModel= UploadModel.builder()
                                    .email(videoUploadRequest.getEmail())
                                    .fileInName(multipartFile.getOriginalFilename())
                                     .status(Status.RECEIVED)
                                    .build();

        log.info("Criando registo na base de dados, {}", uploadModel);
        var uploadModelFromDB = repository.save(uploadModel);

        try {
            var tempFile = Files.createTempFile(uploadModelFromDB.getId()+"-", multipartFile.getOriginalFilename());
            Files.copy(multipartFile.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
            fileService.upload(tempFile);

            Files.delete(tempFile);
        }catch (IOException e) {
            log.error("Erro ao enviar o arquivo {}", multipartFile.getOriginalFilename());
            uploadModelFromDB.setStatus(Status.ERROR);
        }

        uploadModelFromDB.setStatus(Status.IN_PROCESS);
        return repository.save(uploadModelFromDB);
    }
}
