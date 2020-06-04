package com.crnl.repos;

import com.crnl.domain.UserPersonalData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserPersonalDataRepos extends CrudRepository<UserPersonalData, Long> {
    Optional<UserPersonalData> findById(Long id);

}
