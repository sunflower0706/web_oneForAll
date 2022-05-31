package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    @Override
    @Query(value = "SELECT d from Director d ORDER BY d.id")
    ArrayList<Director> findAll();

    @Query(value = "SELECT  d.id FROM Director d WHERE d.ho =:ho AND d.ten = :ten")
    int findByHoAndTen(@Param("ho") String ho, @Param("ten") String ten);

    @Query(value = "SELECT MAX (a.id) FROM Director a")
    int size();
}
