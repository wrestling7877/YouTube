package com.example.controller;

import com.example.dto.attachDto.AttachDto;
import com.example.service.AttachService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/attach")
@Tag(name = "AuthController API", description = "Api list for AuthController")

public class AttachController {

    @Autowired
    private AttachService attachService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        String fileName = attachService.saveToSystem(file);
        return ResponseEntity.ok().body(fileName);
    }

    @GetMapping(value = "/open/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] open(@PathVariable("id") String id) {

        return this.attachService.loadImage(id);
    }



    @GetMapping(value = "/open_general/{id}", produces = MediaType.ALL_VALUE)
    public byte[] open_general(@PathVariable("id") String id) {
        return attachService.open_general(id);
    }




    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") String id) {
        Resource file = attachService.download(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/admin/page")
    public ResponseEntity<?> getPage(@RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size ) {


        Page<AttachDto> result = attachService.loadImageAllPage(page, size);

        return ResponseEntity.ok(result);
    }



    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {

        Boolean result = attachService.fileDelete(id);
        return ResponseEntity.ok(result);
    }


}
