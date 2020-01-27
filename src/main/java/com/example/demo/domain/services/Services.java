package com.example.demo.domain.services;

import com.example.demo.domain.model.*;
import com.example.demo.repository.*;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Services {
    @Autowired StudentsRepo studRepo;
    @Autowired GuardiansRepo guardRepo;
    @Autowired RelationshipsRepo relRepo;
    @Autowired CoursesRepo courseRepo;
    @Autowired TranscriptRepo transRepo;

    public Services() {}
    public Services(StudentsRepo s, GuardiansRepo g, RelationshipsRepo r,
                    CoursesRepo c, TranscriptRepo t){
        this.studRepo = s;
        this.guardRepo = g;
        this.relRepo = r;
        this.courseRepo = c;
        this.transRepo = t;
    }

    // Return a student's guardians and courses.
    public JsonObject getAssociatedFeatures(String name) {
        // Get student id and then match through bridge tables
        Integer studentSid = this.studRepo.findByName(name).getSid();
        List<Relationships> matching_gid = this.relRepo.findBySid(studentSid);
        List<Transcript> matching_cid = this.transRepo.findBySid(studentSid);
        // For each match, find appropriate guardian / course title
        List<String> guardians = new ArrayList<>();
        for (Relationships relation: matching_gid)
            guardians.add(this.guardRepo.findByGid(relation.getGid()).getName());
        List<String> courses = new ArrayList<>();
        for (Transcript course : matching_cid)
            courses.add(this.courseRepo.findByCid(course.getCid()).getTitle());

        // Build Response
        JsonObject response = new JsonObject();
        response.addProperty("name", name);
        response.addProperty("guardians", guardians.toString());
        response.addProperty("courses", courses.toString());
        return response;
    }

    // Return all students with a particular grade
    public JsonObject getStudentsWithGrade(String course_title, grade_t grade) {
        // Get course number and then match through bridge table
        Integer course_no = this.courseRepo.findByTitle(course_title).getCid();
        List<Transcript> matching_grades = this.transRepo.findByGradeAndCid(grade, course_no);
        // For each match, find appropriate grade
        List<String> students = new ArrayList<>();
        for (Transcript match : matching_grades) {
            students.add(this.studRepo.findBySid(match.getSid()).getName());
        }
        // Build response
        JsonObject response = new JsonObject();
        response.addProperty("course_title", course_title);
        response.addProperty("cid", course_no);
        response.addProperty("grade", grade.toString());
        response.addProperty("students", students.toString());
        return response;
    }

    public JsonObject getGradesByCourse(String course_title) {
        // Filter by Course Number and grades
        Integer course_no = this.courseRepo.findByTitle(course_title).getCid();
        List<Transcript> allGrades = this.transRepo.findByCid(course_no);

        // Count number of each grade and build response
        Integer[] counts = {0,0,0,0,0};
        for (Transcript grade : allGrades) {
            counts[grade.getGrade().ordinal()]++;
        }
        JsonObject response = new JsonObject();
        response.addProperty("course_title", course_title);
        response.addProperty("cid", course_no);
        for (grade_t grade : grade_t.values()) {
            response.addProperty(grade.toString(), counts[grade.ordinal()]);
        }
        return response;
    }
}
