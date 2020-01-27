package com.example.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Courses")
public class Courses {
    @Id
    @Column(name="cid")
    private Integer cid;
    @Column(name="subject")
    private String subject;
    @Column(name="title")
    private String title;

    // Constructors
    public Courses() {}
    public Courses(Integer cid, String subject, String title) {
        this.cid = cid;
        this.subject = subject;
        this.title = title;
    }

    // Getters and setters
    public Integer getCid() { return cid; }
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public void setCid(Integer cid) { this.cid = cid; }
    public void setTitle(String title) { this.title = title; }
    public void setSubject(String subject) { this.subject = subject; }
}
