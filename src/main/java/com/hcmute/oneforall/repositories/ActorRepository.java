package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Actor;
import com.hcmute.oneforall.beans.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Override
    @Query(value = "SELECT a FROM Actor a ORDER BY a.id")
    ArrayList<Actor> findAll();

    @Query(value = "SELECT a.id FROM Actor a WHERE a.ho = :ho AND a.ten = :ten")
    int findByHoAndTen(@Param("ho") String ho, @Param("ten") String ten);

    @Query(value = "SELECT MAX(a.id) FROM Actor a")
    int size();
}
