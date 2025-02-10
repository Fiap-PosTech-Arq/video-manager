package br.com.fiap.postech.video_manager.infra.repositories;

import br.com.fiap.postech.video_manager.infra.repositories.entities.UploadEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UploadRepository extends MongoRepository<UploadEntity, String> {
}
