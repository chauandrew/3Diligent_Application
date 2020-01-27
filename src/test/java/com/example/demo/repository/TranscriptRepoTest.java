package com.example.demo.repository;

import com.example.demo.domain.model.Courses;
import com.example.demo.domain.model.Students;
import com.example.demo.domain.model.Transcript;
import com.example.demo.domain.model.grade_t;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class TranscriptRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TranscriptRepo repo;

    @Test
    void findByGradeAndCid() {
        // initialize db
        Students s = new Students(1234, "Test_Student");
        Courses c = new Courses (1234, "Test_Subject", "Test_Course");
        Transcript t = new Transcript(1234, 1234, grade_t.A);
        entityManager.persist(s);
        entityManager.persist(c);
        entityManager.persist(t);
        entityManager.flush();

        // Search
        List<Transcript> found = repo.findByGradeAndCid(grade_t.A, 1234);

        // Asserts
        assertEquals(t.getCid(),   found.get(0).getCid());
        assertEquals(t.getGrade(), found.get(0).getGrade());
        assertEquals(t.getSid(),   found.get(0).getSid());
    }

    @Test
    void findByCid() {
        // initialize db
        Students s = new Students(1234, "Test_Student");
        Courses c = new Courses (1234, "Test_Subject", "Test_Course");
        Transcript t = new Transcript(1234, 1234, grade_t.A);
        entityManager.persist(s);
        entityManager.persist(c);
        entityManager.persist(t);
        entityManager.flush();

        // Search
        List<Transcript> found = repo.findByCid(1234);

        // Asserts
        assertEquals(t.getCid(),   found.get(0).getCid());
        assertEquals(t.getGrade(), found.get(0).getGrade());
        assertEquals(t.getSid(),   found.get(0).getSid());
    }

    @Test
    void findBySid() {
        // initialize db
        Students s = new Students(1234, "Test_Student");
        Courses c = new Courses (1234, "Test_Subject", "Test_Course");
        Transcript t = new Transcript(1234, 1234, grade_t.A);
        entityManager.persist(s);
        entityManager.persist(c);
        entityManager.persist(t);
        entityManager.flush();

        // Search
        List<Transcript> found = repo.findBySid(1234);

        // Asserts
        assertEquals(t.getCid(),   found.get(0).getCid());
        assertEquals(t.getGrade(), found.get(0).getGrade());
        assertEquals(t.getSid(),   found.get(0).getSid());
    }
}