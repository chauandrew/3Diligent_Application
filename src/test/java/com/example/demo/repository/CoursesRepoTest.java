package com.example.demo.repository;

import com.example.demo.domain.model.Courses;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class CoursesRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CoursesRepo repo;

    @Test
    void findByTitle() {
        // create row
        Courses mechanics = new Courses(10, "physics", "classical_mechanics");
        entityManager.persist(mechanics);
        entityManager.flush();

        // search
        Courses found = repo.findByTitle(mechanics.getTitle());

        assertEquals(mechanics.getTitle(), found.getTitle());
        assertEquals(mechanics.getCid(), found.getCid());
        assertEquals(mechanics.getSubject(), found.getSubject());
    }

    @Test
    void findByCid() {
        // create row
        Courses mechanics = new Courses(10, "physics", "classical_mechanics");
        entityManager.persist(mechanics);
        entityManager.flush();

        // search
        Courses found = repo.findByCid(mechanics.getCid());

        assertEquals(mechanics.getTitle(), found.getTitle());
        assertEquals(mechanics.getCid(), found.getCid());
        assertEquals(mechanics.getSubject(), found.getSubject());
    }
}