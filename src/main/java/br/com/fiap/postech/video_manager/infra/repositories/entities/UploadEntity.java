package br.com.fiap.postech.video_manager.infra.repositories.entities;


import br.com.fiap.postech.video_manager.domain.entities.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "uploads")
public class UploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "file_in_name")
    private String fileInName;

    @Column(name = "file_out_name")
    private String fileOutName;

    @Column(name = "status")
    private Status status;

    @PrePersist
    public void setCreateDate() {
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpDate() {
        this.updateAt = LocalDateTime.now();
    }
}
