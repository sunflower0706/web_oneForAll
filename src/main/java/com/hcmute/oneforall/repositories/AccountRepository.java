package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByEmail(String email);
}
