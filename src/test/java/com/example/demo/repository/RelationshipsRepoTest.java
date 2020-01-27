package com.example.demo.repository;

import com.example.demo.domain.model.Guardians;
import com.example.demo.domain.model.Relationships;
import com.example.demo.domain.model.Students;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class RelationshipsRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RelationshipsRepo repo;

    @Test
    void findBySid() {
        // initialize variables and flush to db
        Students s = new Students(1234, "Test_Student");
        Guardians g = new Guardians(1234, "Test_Parent");
        List<Relationships> rel = new ArrayList<Relationships>(
              Arrays.asList(new Relationships(1234, 1234)));
        entityManager.persist(s);
        entityManager.persist(g);
        for (Relationships r : rel)
            entityManager.persist(r);
        entityManager.flush();

        // find in db
        List<Relationships> found = repo.findBySid(1234);

        // compare
        for (Integer i = 0; i < rel.size() && i < found.size(); ++i) {
            assertEquals(rel.get(i).getGid(), found.get(i).getGid());
            assertEquals(rel.get(i).getSid(), found.get(i).getSid());
        }
    }
}