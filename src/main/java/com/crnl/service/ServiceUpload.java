package com.crnl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ServiceUpload {

    @Value("${upload.path}") /*Говорим спрингу что хотим получить переменную
    (выдёргивает из контекста или из конструкции и вставляет в переменную (ниже))*/
    private String uploadPath;

    public ServiceUpload() {
    }

    public String saveUploadFileAndGetFileName(MultipartFile file, String oldFileName) throws IOException {

        if (!file.isEmpty()){
            if (!oldFileName.equals("")) {
                new File(uploadPath + "/" + oldFileName).delete();
            }
            return getFilename(file);
        }
        return null;
    }
    public String saveUploadFileAndGetFileName(MultipartFile file) throws IOException {

        if (!file.isEmpty()){
            return getFilename(file);
        }
        return null;
    }

    public String getFilename(MultipartFile file) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
        /*Создаём уникальеон имя файла, защита от коллизий*/
        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadPath + "/" + resultFilename)); /* Загружаем файл в директорию (сохраняем сам файл)*/
        return resultFilename;
    }

}
