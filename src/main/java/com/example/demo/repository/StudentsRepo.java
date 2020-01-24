package com.example.demo.repository;

import com.example.demo.domain.model.Students;
import com.example.demo.domain.model.grade_t;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {
    // this is a very poorly designed query but was having trouble w/ jpa.
    @Query("SELECT g.name FROM Students s, Guardians g, Relationships r " +
            "WHERE s.name = :name AND s.sid = r.sid AND r.gid = g.gid")
    public List<String> findGuardians(String name);

    @Query("SELECT c.title FROM Students s, Courses c, Transcript t " +
            "WHERE s.name = :name AND s.sid = t.sid AND t.cid = c.cid")
    public List<String> findCourses(String name);

    public Students findBySid(Integer sid);
//    @Query("SELECT s.name FROM Students s, Courses c, Transcript t " +
//            "WHERE c.title = :title AND c.cid = t.cid AND " +
//            "t.grade = :grade AND t.sid = s.sid")
//    public List<String> findStudentsWithGrades(String title, grade_t grade);
}
