package com.crnl.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "trental")
public class Rental {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private User lessee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tcar_id")
    private Car carnumber;

    private Date rentalStartDate;

    private Date rentalEndDate;

    private Double nds;

    private Double rentPrice;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "tcompany_id")
    private Company company;
    public Rental() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public User getLessee() {
        return lessee;
    }

    public void setLessee(User lessee) {
        this.lessee = lessee;
    }

    public Car getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(Car carnumber) {
        this.carnumber = carnumber;
    }

    public java.util.Date getRentalStartDate() {
        return (java.util.Date)rentalStartDate;
    }

    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public Double getNds() {
        return nds;
    }

    public void setNds(Double nds) {
        this.nds = nds;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }
}
