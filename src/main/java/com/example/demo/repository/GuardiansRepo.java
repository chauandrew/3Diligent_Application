package com.example.demo.repository;

import com.example.demo.domain.model.Guardians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardiansRepo extends JpaRepository<Guardians, Integer> {

}
