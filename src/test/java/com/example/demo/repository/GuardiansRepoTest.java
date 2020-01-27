package com.example.demo.repository;

import com.example.demo.domain.model.Courses;
import com.example.demo.domain.model.Guardians;
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
class GuardiansRepoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GuardiansRepo repo;

    @Test
    void findByGid() {
        // create row
        Guardians parent = new Guardians(10, "Mike");
        entityManager.persist(parent);
        entityManager.flush();

        // search
        Guardians found = repo.findByGid(parent.getGid());

        //test
        assertEquals(parent.getGid(), found.getGid());
        assertEquals(parent.getName(), found.getName());
    }
}