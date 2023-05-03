package com.SpringBootTest.SpringBootArtifact.Controllers;

import com.SpringBootTest.SpringBootArtifact.Models.FileId;
import com.SpringBootTest.SpringBootArtifact.Services.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService service;

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> readFile(@PathVariable(value = "id") String fileId) {
        GridFsResource resource = service.readFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(resource.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(new ByteArrayResource(IOUtils.toByteArray(resource.getInputStream())));
    }

    @SneakyThrows
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileId> createFile(
            @RequestPart(name = "file") MultipartFile file
    ) {
        return ResponseEntity.ok().body(service.createFile(file));
    }
}
