package br.com.fiap.postech.video_manager.domain.entities;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class VideoUploadRequest {
    private final String email;
    private final MultipartFile file;

    public VideoUploadRequest(String email, MultipartFile file) {
        this.email = email;
        this.file = file;
    }
}
