package com.crnl.repos;

import com.crnl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
