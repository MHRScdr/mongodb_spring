package com.springboot.mongodb.service;

import com.springboot.mongodb.collection.Photo;
import com.springboot.mongodb.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public String addPhoto(String originFileName, MultipartFile image) throws IOException {
        Photo photo = new Photo();
        photo.setTitle(originFileName);
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        return photoRepository.save(photo).getId();
    }

    @Override
    public Photo getPhoto(String id) {
        Photo photo = photoRepository.getPhotoById(id);
        return photo;
    }
}
