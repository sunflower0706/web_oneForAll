package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Override
    public ArrayList<Genre> findAll();

    public Genre findById(int id);
}
