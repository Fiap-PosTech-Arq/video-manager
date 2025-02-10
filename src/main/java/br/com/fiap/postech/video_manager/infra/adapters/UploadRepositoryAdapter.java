package br.com.fiap.postech.video_manager.infra.adapters;

import br.com.fiap.postech.video_manager.domain.entities.UploadModel;
import br.com.fiap.postech.video_manager.domain.ports.UploadRepositoriesPortOut;
import br.com.fiap.postech.video_manager.infra.repositories.UploadRepository;
import br.com.fiap.postech.video_manager.infra.adapters.mappers.UploadMapper;
import br.com.fiap.postech.video_manager.infra.repositories.entities.UploadEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UploadRepositoryAdapter implements UploadRepositoriesPortOut {

    private final UploadRepository repository;
    private final UploadMapper mapper;

    @Override
    public UploadModel save(UploadModel uploadModel) {
         UploadEntity entity = mapper.toEntity(uploadModel);
         var response = repository.save(entity);

         return mapper.toModel(response);
    }
}
