package com.crnl.service;

import com.crnl.domain.Car;
import com.crnl.domain.Company;
import com.crnl.repos.CompanyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepos companyRepos;

    public List<Company> findAll() {
        return companyRepos.findAll();
    }

    public boolean addCompany(
            String titleCompany,
            String inn,
            String ogrn,
            String bik,
            String k_c,
            String legalAddress,
            String address,
            String phone,
            String checkingAccount,
            Date dateRegistration,
            String contractTemplate,
            String deliveryCertificateTemplate
    ){
        Company company = new Company(titleCompany, inn, ogrn, bik, k_c, legalAddress, address, phone, checkingAccount,
                dateRegistration, contractTemplate, deliveryCertificateTemplate);

        Company companyFromDB = companyRepos.findByTitleCompany(company.getTitleCompany());

        if (companyFromDB != null){
            return false;
        }

        companyRepos.save(company);
        return true;
    }

    public void saveCompany(
            String titleCompany,
            String inn,
            String ogrn,
            String bik,
            String k_c,
            String legalAddress,
            String address,
            String phone,
            String checkingAccount,
            Date dateRegistration,
            String contractTemplate,
            String deliveryCertificateTemplate,
            Company company
    ) {
        company.setTitleCompany(titleCompany);
        company.setInn(inn);
        company.setOgrn(ogrn);
        company.setBik(bik);
        company.setK_c(k_c);
        company.setLegalAddress(legalAddress);
        company.setAddress(address);
        company.setPhone(phone);
        company.setCheckingAccount(checkingAccount);
        company.setDateRegistration(dateRegistration);
        company.setContractTemplate(contractTemplate);
        company.setDeliveryCertificateTemplate(deliveryCertificateTemplate);

        companyRepos.save(company);
    }

    public Company findById(Long id) {
        if (companyRepos.findById(id).isPresent())
            return companyRepos.findById(id).get();
        else
            return new Company();
    }
}
