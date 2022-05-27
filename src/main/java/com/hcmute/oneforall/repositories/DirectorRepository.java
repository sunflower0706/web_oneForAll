package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    @Override
    ArrayList<Director> findAll();
}
