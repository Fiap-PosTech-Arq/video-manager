package br.com.fiap.postech.video_manager.domain.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@ToString
@Data
@Builder
public class UploadModel {
    private String id;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String fileInName;
    private String fileOutName;
    private Status status;
}
