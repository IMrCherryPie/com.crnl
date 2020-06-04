package com.crnl.controller;

import com.crnl.service.CarService;
import com.crnl.service.CompanyService;
import com.crnl.service.RentalService;
import com.crnl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.ParseException;

@Controller
public class RentalController {

    @Autowired
    RentalService rentalService;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/rental")
    public String rentalList(Model model){
        model.addAttribute("rentals", rentalService.findAll());
        return "rentalList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/registrationRental")
    public String rentalRegistration(
            @RequestParam Date rentalStartDate,
            @RequestParam Date rentalEndDate,
            @RequestParam Long userId,
            @RequestParam Long companyId,
            @RequestParam Long carId) throws ParseException {
        rentalService.saveRental(rentalStartDate, rentalEndDate, userId, carId, companyId);
        return "redirect:/rental";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/rentalAdd")
    public String rentalAdd(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("companys", companyService.findAll());

        return "rentalAdd";
    }
}
