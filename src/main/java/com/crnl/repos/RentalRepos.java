package com.crnl.repos;

import com.crnl.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepos extends JpaRepository<Rental, Long> {

    List<Rental> findAll();

}
