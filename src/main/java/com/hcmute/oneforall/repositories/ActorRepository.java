package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Override
    ArrayList<Actor> findAll();
}
