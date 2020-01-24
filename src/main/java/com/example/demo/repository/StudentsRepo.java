package com.example.demo.repository;

import com.example.demo.domain.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {
    public Students findByName(String name);
    public Students findBySid(Integer sid);
}
