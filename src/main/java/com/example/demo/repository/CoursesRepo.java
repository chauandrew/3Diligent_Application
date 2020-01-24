package com.example.demo.repository;

import com.example.demo.domain.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Integer> {
    public Courses findByTitle(String title);
    public Courses findByCid(Integer cid);
}
