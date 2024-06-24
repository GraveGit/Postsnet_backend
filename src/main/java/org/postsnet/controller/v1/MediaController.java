package org.postsnet.controller.v1;

import lombok.RequiredArgsConstructor;
import org.postsnet.dto.MediaDTO;
import org.postsnet.entity.Media;
import org.postsnet.service.MediaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/")
    public Media create(@RequestBody MediaDTO dto) throws Exception {
        return mediaService.create(dto);
    }

    @GetMapping("/{id}")
    public Media readById(@PathVariable Long id) throws Exception {
        return mediaService.readById(id);
    }
}
