package com.example.demo.webapi.controller;

import com.example.demo.domain.services.Services;
import com.example.demo.repository.*;
import com.example.demo.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentsController {
    // Repository Declarations
    @Autowired StudentsRepo studentsRepo;
    @Autowired GuardiansRepo guardiansRepo;
    @Autowired RelationshipsRepo relationshipsRepo;
    @Autowired CoursesRepo coursesRepo;
    @Autowired TranscriptRepo transcriptRepo;

    // TODO: Change path arguments to query parameters

    // Get all appropriate data by student name
    @GetMapping("/students/{name}")
    public String getGuardiansAndGradesByName(@PathVariable(value = "name") String name) {
        Services service = new Services(studentsRepo, guardiansRepo,
                                    relationshipsRepo, coursesRepo, transcriptRepo);
        return service.getAssociatedFeatures(name).toString();
    }

    // Find students with specific grade in a specific course
    @GetMapping("/{course}/{grade}")
    public String getStudentsWithGrade(
            @PathVariable(value="course") String course,
            @PathVariable(value="grade") grade_t grade) {
        Services service = new Services(studentsRepo, guardiansRepo,
                relationshipsRepo, coursesRepo, transcriptRepo);
        return service.getStudentsWithGrade(course, grade).toString();
    }

    // Get distribution of all grades in a specific course
    @GetMapping("grades/{course}")
    public String getGradesByCourse(@PathVariable(value="course") String course) {
        Services service = new Services(studentsRepo, guardiansRepo,
                relationshipsRepo, coursesRepo, transcriptRepo);
        return service.getGradesByCourse(course).toString();
    }

    // TODO: Basic put/get functions for testing

}
