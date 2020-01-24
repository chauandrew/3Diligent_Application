package com.example.demo.domain.services;

import com.example.demo.domain.model.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Services {
    private StudentsRepo studRepo;
    private GuardiansRepo guardRepo;
    private RelationshipsRepo relRepo;
    private CoursesRepo courseRepo;
    private TranscriptRepo transRepo;

    public Services(StudentsRepo s, GuardiansRepo g, RelationshipsRepo r,
                    CoursesRepo c, TranscriptRepo t){
        this.studRepo = s;
        this.guardRepo = g;
        this.relRepo = r;
        this.courseRepo = c;
        this.transRepo = t;
    }

    // Return a student's guardians and courses.
    // If student doesn't exist, throws ResourceNotFoundException
    public JsonObject getAssociatedFeatures(String name) {
        JsonObject response = new JsonObject();
        List<String> guardians = this.studRepo.findGuardians(name);
        List<String> courses = this.studRepo.findCourses(name);
        if (guardians.isEmpty() && courses.isEmpty()) {
            throw new ResourceNotFoundException("Student", "name", name);
        }
        response.addProperty("name", name);
        response.addProperty("guardians", guardians.toString());
        response.addProperty("courses", courses.toString());
        return response;
    }

    // Return all students with a particular grade
    public JsonObject getStudentsWithGrade(String course_title, grade_t grade) {
        JsonObject response = new JsonObject();
        Integer course_no = this.courseRepo.findByTitle(course_title).getCid();

        List<Transcript> matching_grades = this.transRepo.findByGradeAndCid(grade, course_no);
        List<String> students = new ArrayList<>();
        for (Transcript match : matching_grades) {
            students.add(this.studRepo.findBySid(match.getSid()).getName());
        }
        response.addProperty("course_title", course_title);
        response.addProperty("cid", course_no);
        response.addProperty("grade", grade.toString());
        response.addProperty("students", students.toString());
        return response;
    }

    public JsonObject getGradesByCourse(String course_title) {
        JsonObject response = new JsonObject();
        Integer course_no = this.courseRepo.findByTitle(course_title).getCid();
        List<Transcript> allGrades = this.transRepo.findByCid(course_no);

        Integer[] counts = {0,0,0,0,0};
        for (Transcript grade : allGrades) {
            counts[grade.getGrade().ordinal()]++;
        }
        response.addProperty("course_title", course_title);
        response.addProperty("cid", course_no);
        for (grade_t grade : grade_t.values()) {
            response.addProperty(grade.toString(), counts[grade.ordinal()]);
        }
        return response;
    }
}
