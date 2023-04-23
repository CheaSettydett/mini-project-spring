package com.istad.miniprojectspring.service.serviceImpl;

import com.istad.miniprojectspring.service.FileUploadService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadserviceImpl implements FileUploadService {
    Path fileLocationStorge;
    FileUploadserviceImpl(){
        fileLocationStorge = Path.of("E:\\Lesson ISTAD\\Spring\\demo\\mini-project-spring\\src\\main\\resources\\images");
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        if(filename!=null){
            //condition for filename
            if(filename.contains("..")){
                System.out.println("Filename is incorrect !!");
                return null;
            }
            String[] fileParts = filename.split("\\.");
            filename = UUID.randomUUID() +"."+fileParts[1];

            //resolve path

            Path resolvePath =  fileLocationStorge.resolve(filename);
            Files.copy(file.getInputStream(),resolvePath, StandardCopyOption.REPLACE_EXISTING);
            return filename;
        }
        return null;
    }
}
