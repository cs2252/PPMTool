package com.example.ppmtool.repositories;

import com.example.ppmtool.domain.Chand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChandRepository extends JpaRepository<Chand, Integer> {

}

