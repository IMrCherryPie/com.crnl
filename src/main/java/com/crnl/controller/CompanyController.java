package com.crnl.controller;

import com.crnl.domain.Company;
import com.crnl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/companyList")
    public String companyList(Model model){
        model.addAttribute("companys", companyService.findAll());
        return "/companyList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("company/{company}")
    public String companyEditForm(
            @PathVariable Company company, Model model){
        model.addAttribute("company", company);

        return "companyEdit";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("addCompany")
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
            @RequestParam Date dateRegistration,
            @RequestParam String contractTemplate,
            @RequestParam String deliveryCertificateTemplate
    ){
        Company company;
        companyService.saveCompany(
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
                deliveryCertificateTemplate,
                company = new Company()
                );
        return "redirect:/companyList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("editCompany")
    public String editCompany(
            @RequestParam String titleCompany,
            @RequestParam String inn,
            @RequestParam String ogrn,
            @RequestParam String bik,
            @RequestParam String k_c,
            @RequestParam String legalAddress,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam String checkingAccount,
            @RequestParam Date dateRegistration,
            @RequestParam String contractTemplate,
            @RequestParam String deliveryCertificateTemplate,
            @RequestParam("companyId") Company company
    ){
        companyService.saveCompany(
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
                deliveryCertificateTemplate,
                company
                );
        return "redirect:/companyList";
    }



}


