package br.com.fiap.postech.video_manager.domain.ports;

import java.nio.file.Path;

public interface FileServicePortOut {

    void upload(Path file);

}
