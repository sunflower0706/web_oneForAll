package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
