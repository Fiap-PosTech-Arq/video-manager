package br.com.fiap.postech.video_manager.infra.repositories.entities;


import br.com.fiap.postech.video_manager.domain.entities.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Getter
@Setter
@Document(collection = "uploads")
public class UploadEntity {

    @Id
    private String id;

    @Indexed
    @Field("email")
    private String email;

    @Field("create_at")
    private LocalDateTime createAt;

    @Field("update_at")
    private LocalDateTime updateAt;

    @Field("file_in_name")
    private String fileInName;

    @Field("file_out_name")
    private String fileOutName;

    @Field("status")
    private Status status;
}
