package com.example.demo.webapi.controller;

import com.example.demo.domain.services.Services;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonObject;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsController {
    // Repository Declarations
    @Autowired StudentsRepo studentsRepo;
    @Autowired GuardiansRepo guardiansRepo;
    @Autowired RelationshipsRepo relationshipsRepo;
    @Autowired CoursesRepo coursesRepo;
    @Autowired TranscriptRepo transcriptRepo;

    @GetMapping("/students/{name}")
    public String getGuardiansAndGradesByName(@PathVariable(value = "name") String name) {
        Services service = new Services(studentsRepo, guardiansRepo,
                                    relationshipsRepo, coursesRepo, transcriptRepo);
        return service.getAssociatedFeatures(name).toString();
    }

    @GetMapping("/{course}/{grade}")
    public String getStudentsWithGrade(
            @PathVariable(value="course") String course,
            @PathVariable(value="grade") grade_t grade) {
        Services service = new Services(studentsRepo, guardiansRepo,
                relationshipsRepo, coursesRepo, transcriptRepo);
        return service.getStudentsWithGrade(course, grade).toString();
    }

    @GetMapping("grades/{course}")
    public String getGradesByCourse(@PathVariable(value="course") String course) {
        Services service = new Services(studentsRepo, guardiansRepo,
                relationshipsRepo, coursesRepo, transcriptRepo);
        return service.getGradesByCourse(course).toString();
    }
}
