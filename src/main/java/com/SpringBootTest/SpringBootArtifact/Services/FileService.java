package com.SpringBootTest.SpringBootArtifact.Services;

import com.SpringBootTest.SpringBootArtifact.Models.FileId;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {
    private final GridFsTemplate gridFsTemplate;

    public FileService(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    public GridFsResource readFile(String fileId) throws FileNotFoundException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(fileId)));
        if (Optional.ofNullable(file).isPresent()) return gridFsTemplate.getResource(file.getFilename());
        throw new FileNotFoundException();
    }

    public FileId createFile(MultipartFile file) throws IOException {
        DBObject metaData = createMetadata(file);
        ObjectId newFileId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(),
                file.getContentType(), metaData);
        return new FileId(newFileId.toString());
    }

    private DBObject createMetadata(MultipartFile file) {
        DBObject metaData = new BasicDBObject();
        metaData.put("_contentType", file.getContentType());
        metaData.put("type", file.getContentType());
        metaData.put("name", file.getOriginalFilename());
        return metaData;
    }
}
