package com.example.demo.domain.services;

import com.example.demo.repository.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.domain.model.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Services.class})
class ServicesTest {

    @TestConfiguration
    static class ServicesTestContextConfig {

        @Bean
        public Services service() {
            return new Services();
        }
        @Bean
        public Services service(StudentsRepo s, GuardiansRepo g, RelationshipsRepo r,
                        CoursesRepo c, TranscriptRepo t){
            return new Services(s, g, r, c, t);
        }
    }
//    @InjectMocks private Services service;

    @Autowired
    private Services service;

    @MockBean private StudentsRepo studentsRepo;
    @MockBean private GuardiansRepo guardiansRepo;
    @MockBean private RelationshipsRepo relationshipsRepo;
    @MockBean private CoursesRepo coursesRepo;
    @MockBean private TranscriptRepo transcriptRepo;

//    @Autowired
//    public ServicesTest() {
//        service = new Services(studentsRepo, guardiansRepo, relationshipsRepo,
//                coursesRepo, transcriptRepo);
//    }

    @Before
    public void setUp() {
        Students s = new Students(1234, "Test_Student");
        Guardians g = new Guardians(2345, "Test_Guardian");
        Relationships r = new Relationships(1234, 2345);
        Courses c = new Courses(3456, "Test_Subject", "Test_Title");
        Transcript t = new Transcript(1234, 3456, grade_t.A);

        Mockito.when(studentsRepo.findByName(s.getName())).thenReturn(s);
        Mockito.when(studentsRepo.findBySid(s.getSid())).thenReturn(s);
        Mockito.when(guardiansRepo.findByGid(g.getGid())).thenReturn(g);
        Mockito.when(relationshipsRepo.findBySid(r.getSid()))
                .thenReturn(new ArrayList<>(Arrays.asList(r)));
        Mockito.when(coursesRepo.findByTitle(c.getTitle())).thenReturn(c);
        Mockito.when(coursesRepo.findByCid(c.getCid())).thenReturn(c);
        Mockito.when(transcriptRepo.findByCid(t.getCid())).thenReturn(new ArrayList<>(Arrays.asList(t)));
        Mockito.when(transcriptRepo.findBySid(t.getSid())).thenReturn(new ArrayList<>(Arrays.asList(t)));
        Mockito.when(transcriptRepo.findByGradeAndCid(t.getGrade(), t.getCid()))
                .thenReturn(new ArrayList<>(Arrays.asList(t)));
    }

    @Test
    void getAssociatedFeatures() {
        setUp();
        String response = service.getAssociatedFeatures("Test_Student").toString();
        assertTrue(response.contains("Test_Title"));
        assertTrue(response.contains("Test_Guardian"));
    }

    @Test
    void getStudentsWithGrade() {
        setUp();
        String response = service.getStudentsWithGrade("Test_Title", grade_t.A).toString();
        assertTrue(response.contains("Test_Student"));
        response = service.getStudentsWithGrade("Test_Title", grade_t.B).toString();
        assertFalse(response.contains("Test_Student"));
    }

    @Test
    void getGradesByCourse() {
        setUp();
        String response = service.getGradesByCourse("Test_Title").toString();
        assertTrue(response.contains("\"A\":1"));
        assertTrue(response.contains("\"B\":0"));
        assertTrue(response.contains("\"C\":0"));
        assertTrue(response.contains("\"D\":0"));
        assertTrue(response.contains("\"F\":0"));
    }
}