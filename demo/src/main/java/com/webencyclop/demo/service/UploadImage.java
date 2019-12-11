package com.webencyclop.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadImage {
    private String upload_folder=".//src//main//resources//static//images//";
    public void savefile(MultipartFile file)throws IOException{
        if(!file.isEmpty()){
            byte[] bytes=file.getBytes();
            Path path=Paths.get(upload_folder+file.getOriginalFilename());
            Files.write(path, bytes);
        }
    }
}