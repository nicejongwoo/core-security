package com.core.sec.repository;

import com.core.sec.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

    void deleteByUsername(String username);
}
