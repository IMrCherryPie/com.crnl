package com.crnl.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "tcompany")
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String titleCompany;

    private String inn;

    private String ogrn;

    private String bik;

    private String k_c;

    private String legalAddress;

    private String address;

    private String phone;

    private String checkingAccount;

    private Date dateRegistration;

    private String contractTemplate;

    private String deliveryCertificateTemplate;

    public Company() {
    }

    public Company(
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
    ) {
        this.titleCompany = titleCompany;
        this.inn = inn;
        this.ogrn = ogrn;
        this.bik = bik;
        this.k_c = k_c;
        this.legalAddress = legalAddress;
        this.address = address;
        this.phone = phone;
        this.checkingAccount = checkingAccount;
        this.dateRegistration = dateRegistration;
        this.contractTemplate = contractTemplate;
        this.deliveryCertificateTemplate = deliveryCertificateTemplate;
    }

    public Long getId() {
        return id;
    }

    public String getTitleCompany() {
        return titleCompany;
    }

    public void setTitleCompany(String titleCompany) {
        this.titleCompany = titleCompany;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getK_c() {
        return k_c;
    }

    public void setK_c(String k_c) {
        this.k_c = k_c;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getContractTemplate() {
        return contractTemplate;
    }

    public void setContractTemplate(String contractTemplate) {
        this.contractTemplate = contractTemplate;
    }

    public String getDeliveryCertificateTemplate() {
        return deliveryCertificateTemplate;
    }

    public void setDeliveryCertificateTemplate(String deliveryCertificateTemplate) {
        this.deliveryCertificateTemplate = deliveryCertificateTemplate;
    }
}
