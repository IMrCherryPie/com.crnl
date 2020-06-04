package com.crnl.controller;

import com.crnl.domain.Car;
import com.crnl.domain.Company;
import com.crnl.domain.User;
import com.crnl.service.*;
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
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CarService carService;

    @Autowired
    private RentalService rentalService;

    @Autowired
    UserPersonalDataService userPersonalDataService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        if(!userService.addUser(user)){/*Если мы не смогли добавить пользователя, значит пользователь существует*/
            model.put("message", "User exists");
            return "registration";
        }

        return "redirect:/main";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/registrationCar")
    public String addCar(
            @RequestParam String stateNumber,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String color,
            @RequestParam Date yearOfManufacture,
            @RequestParam String vinBody,
            @RequestParam String vinEngine,
            @RequestParam Double   costOfRental,
            @RequestParam Boolean inRental,
            @RequestParam String  registrationCertificate,
            @RequestParam ("file") MultipartFile file,
            @RequestParam Map<String, Object> modell) throws IOException {
        if(!carService.addCar(
                stateNumber,
                brand,
                model,
                color,
                yearOfManufacture,
                vinBody,
                vinEngine,
                costOfRental,
                inRental,
                registrationCertificate,
                file
        )) {  /*Если мы не смогли добавить пользователя, значит пользователь существует*/
            modell.put("message", "Car name exists");

            return "redirect:/car";
        }


        Iterable<Car> cars =  carService.findAll();
        modell.put("car", cars);
        modell.put("message", "Car added");
        return "redirect:/car";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/registrationCompany")
    public String addCompany(
            @RequestParam String titleCompany,
            @RequestParam String inn,
            @RequestParam String ogrn,
            @RequestParam String bik,
            @RequestParam String k_c,
            @RequestParam String legalAddress,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam String checkingAccount,
            @RequestParam Date   dateRegistration,
            @RequestParam String contractTemplate,
            @RequestParam String deliveryCertificateTemplate,
            @RequestParam Map<String, Object> model
    ) {

        if(!companyService.addCompany(
                titleCompany,
                inn,
                ogrn,
                bik,
                k_c,
                legalAddress,
                address,
                phone,
                checkingAccount,
                dateRegistration,
                contractTemplate,
                deliveryCertificateTemplate)) {/*Если мы не смогли добавить пользователя, значит пользователь существует*/
            model.put("message", "Company name exists");

            return "redirect:/company";
        }


        Iterable<Company> companies =  companyService.findAll();
        model.put("company", companies);
        model.put("message", "Company added");
        return "redirect:/company";
    }

    @PostMapping("/registrationRental/{userId}")
    public String addRental(@PathVariable("userId") User user, Car car, Model model){


        return  "redirect:/rental";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivate = userService.activateUser(code);

        if (isActivate) {
            model.addAttribute("message", "User successfully activated");
        }else{
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }

    @PostMapping("/registrationPersonalDataInTimeIssue")
    public String registrationUserPersonalData(
            @RequestParam("carId") Long carId,
            @RequestParam("userId") Long userId,
            @RequestParam Map <String, String> form
    ) {
        userPersonalDataService.registrationUserPersonalData(form);

        return "/greeting";
    }
}
