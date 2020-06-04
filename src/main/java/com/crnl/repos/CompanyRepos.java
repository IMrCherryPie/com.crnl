package com.crnl.repos;

import com.crnl.domain.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepos extends CrudRepository<Company, Long> {

    List<Company> findAll();

    Company findByTitleCompany(String titleCompany);
}
