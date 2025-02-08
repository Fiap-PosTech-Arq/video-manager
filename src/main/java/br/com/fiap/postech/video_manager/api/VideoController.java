package br.com.fiap.postech.video_manager.api;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @GetMapping
    public String findAll() {
        return "Olá, os seus vídeos estào aqui";
    }

    @GetMapping("/{id}/frames")
    public String downloadFramesById(@PathVariable("id") String videoId) {
        return "seu-video.zip";
    }


}
