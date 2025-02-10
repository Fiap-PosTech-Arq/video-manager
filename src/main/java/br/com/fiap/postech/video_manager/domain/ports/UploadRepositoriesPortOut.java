package br.com.fiap.postech.video_manager.domain.ports;

import br.com.fiap.postech.video_manager.domain.entities.UploadModel;

public interface UploadRepositoriesPortOut {

    UploadModel save(UploadModel uploadModel);
}
