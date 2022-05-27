package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByEmail(String email);
    public Account findById(int id);
    @Override
    ArrayList<Account> findAll();
}
