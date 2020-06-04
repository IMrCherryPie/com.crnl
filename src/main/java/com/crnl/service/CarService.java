package com.crnl.service;

import com.crnl.domain.Car;
import com.crnl.domain.User;
import com.crnl.repos.CarRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepos carRepos;

    @Autowired
    private ServiceUpload serviceUpload;


    @Value("${upload.path}") /* Ишет в проперти upload.path и вставляет в value.
    Говорим спрингу что хотим получить переменную
    (выдёргивает из контекста или из конструкции и вставляет в переменную (ниже))*/
    private String uploadPath;

    public List<Car> findAll() {
        return carRepos.findAll();
    }

    public Car findById(Long id) {

        if (carRepos.findById(id).isPresent())
            return carRepos.findById(id).get();
        else
            return new Car();
    }


    public boolean addCar(
            String stateNumber,
            String brand,
            String model,
            String color,
            Date yearOfManufacture,
            String vinBody,
            String vinEngine,
            Double costOfRental,
            Boolean inRental,
            String registrationCertificate,
            MultipartFile file
    ) throws IOException {
        Car car = new Car(
                stateNumber,
                brand,
                model,
                color,
                yearOfManufacture,
                vinBody,
                vinEngine,
                costOfRental,
                inRental,
                registrationCertificate
                );

        String uploadPath = serviceUpload.saveUploadFileAndGetFileName(file);
        if (uploadPath != null) {
            car.setFilename(null);
            car.setFilename(uploadPath);
        }
        Car carFromDB = carRepos.findByVinBody(car.getVinBody());

        if (carFromDB != null){
            return false;
        }
        carRepos.save(car);
        return true;
    }

    public void saveCar(MultipartFile file,String oldFileName, Car car, String stateNumber,String model) throws IOException {
        car.setStateNumber(stateNumber);
        car.setModel(model);
        String fileName = serviceUpload.saveUploadFileAndGetFileName(file, oldFileName);
        if (fileName != null) {
            car.setFilename(fileName);
        }
        carRepos.save(car);
    }


    public void save(Car car) {
        carRepos.save(car);
    }
}
