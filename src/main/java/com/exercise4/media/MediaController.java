package com.exercise4.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/exercise4")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/medias")
    public ResponseEntity<Media> createMedia(@RequestParam String name, @RequestParam(name = "url") String url, @RequestParam(name = "videoLength") Integer videoLength) throws Exception {

        Media createdMedia = mediaService.create(name, url, videoLength);

        if (createdMedia == null) {
                return ResponseEntity.badRequest().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdMedia.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(createdMedia);
        }
    }

    @GetMapping(value = "/medias")
    public ResponseEntity<Object> listMedia() {

        List<Media> medias = mediaService.mediaList();

        if (medias == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(medias);
        }
    }

    @GetMapping(value = "/medias/{id}")
    public ResponseEntity<Object> searchMedia(@PathVariable("id") Integer id) {
        Media foundMedia = mediaService.search(id);

        if (foundMedia == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMedia);
        }
    }
}