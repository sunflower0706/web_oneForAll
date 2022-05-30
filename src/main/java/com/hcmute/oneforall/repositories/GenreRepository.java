package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Override
    ArrayList<Genre> findAll();

    Genre findById(int id);
}
