package com.crnl.service;

import com.crnl.domain.Car;
import com.crnl.domain.Company;
import com.crnl.domain.Rental;
import com.crnl.domain.User;
import com.crnl.repos.RentalRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;

@Service
public class RentalService {

    @Autowired
    RentalRepos rentalRepos;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    CompanyService companyService;

    @Autowired
    com.crnl.service.Service service;


    public Iterable<Rental> findAll() {
        return rentalRepos.findAll();
    }


    public void saveRental(Date rentalStartDate, Date rentalEndDate, Long userId, Long companyId, Long carId) {

        Rental rental = new Rental();

        rental.setRentalStartDate(rentalStartDate);
        rental.setRentalEndDate(rentalEndDate);

        User user = userService.findById(userId);
        Car car = carService.findById(carId);
        Company company = companyService.findById(companyId);

//        rental.setCompany(company);
        rental.setRentPrice(car.getCostOfRental());
//        rental.setCarnumber(car);
        rental.setLessee(user);
        rental.setRentPrice(4d * car.getCostOfRental());
        rental.setNds(4d * car.getCostOfRental() * 0.15);
        rentalRepos.save(rental);
        car.setInRental(true);
        carService.carRepos.save(car);
    }


}
