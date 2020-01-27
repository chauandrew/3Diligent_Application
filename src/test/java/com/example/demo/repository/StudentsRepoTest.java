package com.example.demo.repository;

import com.example.demo.domain.model.Students;
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
class StudentsRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentsRepo repo;

    @Test
    void findByName() {
        Students s = new Students(1234, "Test_Student");
        entityManager.persist(s);
        entityManager.flush();

        Students found = repo.findByName(s.getName());

        assertEquals(s.getName(), found.getName());
        assertEquals(s.getSid(), found.getSid());
    }

    @Test
    void findBySid() {
        Students s = new Students(1234, "Test_Student");
        entityManager.persist(s);
        entityManager.flush();

        Students found = repo.findBySid(s.getSid());

        assertEquals(s.getName(), found.getName());
        assertEquals(s.getSid(), found.getSid());
    }
}