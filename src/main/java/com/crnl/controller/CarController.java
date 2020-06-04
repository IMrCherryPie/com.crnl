package com.crnl.controller;

import com.crnl.domain.Car;
import com.crnl.domain.User;
import com.crnl.service.CarService;
import com.crnl.service.RentalService;
import com.crnl.service.Service;
import com.crnl.service.UserPersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.Map;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    RentalService rentalService;

    @Autowired
    UserPersonalDataService personalDataService;

    @Autowired
    Service service;

    @GetMapping("/car")
    public String carList(Model model){
        model.addAttribute("cars", carService.findAll());
        return "carList";
    }

    @GetMapping("/carPrice")
    public String carPrice(Model model){
        model.addAttribute("cars", carService.findAll());

        return "carPrice";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/car/{car}")
    public String carEditForm(@PathVariable Car car, Model model){
        model.addAttribute("car", car);

        return "carEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/carSave")
    public String carSave(
            @RequestParam MultipartFile file,
            @RequestParam String stateNumber,
            @RequestParam String model,
            @RequestParam("carId") Car car,
            @RequestParam("oldFileName") String oldFileName) throws IOException {
        System.out.println(stateNumber);
        carService.saveCar(file, oldFileName, car, stateNumber,model);

        return "redirect:/car";
    }

    @GetMapping("/carBy/{carId}/{userId}")
    public String carBy(
            @PathVariable("carId") Car car,
            @PathVariable("userId") User user,
            Model model){

        model.addAttribute("car", car);
        model.addAttribute("user", user);
        model.addAttribute("a", "");
        return "/carBy";
    }

    @PostMapping("/rentalCar/{carId},{userId}")
    public String rentalCar(
            @PathVariable("userId") User user,
            @PathVariable("carId") Car car,
            @RequestParam Map<String, String> form,
            Model model) throws ParseException {

        Date rentalStartDate = java.sql.Date.valueOf(form.get("rentalStartDate"));
        Date rentalEndDate = java.sql.Date.valueOf(form.get("rentalEndDate"));

        int day = service.daysBetween(rentalStartDate,rentalEndDate); /*Дней аренды*/
        model.addAttribute("costRental",day *car.getCostOfRental());
        model.addAttribute("nds",day *car.getCostOfRental() * 0.15d);
        model.addAttribute("car", car);
        model.addAttribute("user", user);
        model.addAttribute("a", "s");
        model.addAttribute("rentalStartDate",rentalStartDate);
        model.addAttribute("rentalEndDate",rentalEndDate);


        return "/carBy";
    }

    @PostMapping("/registerADeal")
    public String registerADeal(
            @RequestParam("userId") User user,
            @RequestParam("carId") Car car,
            @RequestParam Map<String, String> form
    ) throws ParseException {


        return "/greeting";
    }


}
