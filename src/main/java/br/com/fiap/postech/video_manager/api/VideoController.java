package br.com.fiap.postech.video_manager.api;


import br.com.fiap.postech.video_manager.api.dtos.UploadResponseDto;
import br.com.fiap.postech.video_manager.domain.entities.UploadModel;
import br.com.fiap.postech.video_manager.domain.entities.VideoUploadRequest;

import br.com.fiap.postech.video_manager.domain.usecases.DownloadFileUseCase;
import br.com.fiap.postech.video_manager.domain.usecases.FindUploadUseCase;
import br.com.fiap.postech.video_manager.domain.usecases.UploadFileUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RequiredArgsConstructor
@RestController
@RequestMapping("/videos")
public class VideoController {

    private final UploadFileUseCase uploadFileUseCase;
    private final DownloadFileUseCase downloadFileUseCase;

    @GetMapping("/{id}/frames")
    public ResponseEntity<byte[]> downloadFramesById(@PathVariable("id") String uploadId) {
        return ResponseEntity.ok(downloadFileUseCase.execute(uploadId));
    }

    @PostMapping
    public ResponseEntity<UploadResponseDto> upload(@RequestHeader("email") String email,
                                                    @RequestParam("file") MultipartFile file) {

        var videoUploadRequest =  new VideoUploadRequest(email, file);
        UploadModel response = uploadFileUseCase.save(videoUploadRequest);

       /** UploadResponseDto dto = mapper.toDto(response);

         dto.add(linkTo(methodOn(VideoController.class)
                 .downloadFramesById(dto.getCode()))
                 .withSelfRel()); */

         return ResponseEntity.ok().build();
    }
}
