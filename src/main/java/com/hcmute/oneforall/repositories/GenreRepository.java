package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Actor;
import com.hcmute.oneforall.beans.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Override
    @Query(value = "SELECT g FROM Genre g ORDER BY g.id")
    ArrayList<Genre> findAll();

    @Query(value = "SELECT g.id FROM Genre g WHERE g.mo_ta = :moTa")
    int findBymota(@Param("moTa") String moTa);

    @Query(value = "SELECT MAX (a.id) FROM Genre a")
    int size();
}
