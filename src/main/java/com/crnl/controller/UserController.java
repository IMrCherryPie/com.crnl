package com.crnl.controller;

import com.crnl.domain.Role;
import com.crnl.domain.User;
import com.crnl.domain.UserPersonalData;
import com.crnl.service.UserPersonalDataService;
import com.crnl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserPersonalDataService userPersonalDataService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model ){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        userService.saveUser(user, username, form);
        return "redirect:/user";
    }

    @GetMapping("/personalData/{userId}")
    public String registrationPersonalData(
            Model model,
            @PathVariable("userId") User user ){

        if (user.isActivePersonalData()) {
            model.addAttribute("personalData", user.getPersonalData());
        }else{
            model.addAttribute("personalData", new UserPersonalData());
        }
        model.addAttribute("user",user);
        return "/userPersonalData";
    }

    @PostMapping("/addPersonalData")
    public String addPersonalData(
            @RequestParam Map <String, String> form,
            Model model){

        userPersonalDataService.registrationUserPersonalData(form);
        Long userId = Long.parseLong(form.get("userId"));
        UserPersonalData personalData = userPersonalDataService.findById(userId);
        model.addAttribute("personalData",personalData);

        return "redirect:/user";
    }

}
