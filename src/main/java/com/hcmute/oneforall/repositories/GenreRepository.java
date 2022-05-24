package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
