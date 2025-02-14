package br.com.fiap.postech.video_manager.infra.repositories;

import br.com.fiap.postech.video_manager.infra.repositories.entities.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UploadRepository extends JpaRepository<UploadEntity, Long> {

    Optional<UploadEntity> findByFileInName(String fileName);
}
