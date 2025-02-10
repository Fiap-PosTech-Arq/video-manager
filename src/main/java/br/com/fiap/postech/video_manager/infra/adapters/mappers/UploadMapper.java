package br.com.fiap.postech.video_manager.infra.adapters.mappers;

import br.com.fiap.postech.video_manager.domain.entities.UploadModel;
import br.com.fiap.postech.video_manager.infra.repositories.entities.UploadEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UploadMapper {
    UploadEntity toEntity(UploadModel model);
    UploadModel toModel(UploadEntity entity);
}
