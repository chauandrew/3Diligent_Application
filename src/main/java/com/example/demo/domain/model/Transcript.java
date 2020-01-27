package com.example.demo.domain.model;

import javax.persistence.*;

@Entity
@Table(name="Transcript")
@IdClass(TranscriptId.class)
public class Transcript {
    @Id @Column(name="sid")
    private Integer sid;
    @Id @Column(name="cid")
    private Integer cid;
    @Column(name="grade")
    @Enumerated(EnumType.STRING)
    private grade_t grade;

    // Constructors
    public Transcript() {}
    public Transcript(Integer sid, Integer cid, grade_t grade) {
        this.sid = sid;
        this.cid = cid;
        this.grade = grade;
    }

    // Getters and setters
    public Integer getSid() { return sid; }
    public Integer getCid() { return cid; }
    public grade_t getGrade() { return grade; }
    public void setSid(Integer sid) { this.sid = sid; }
    public void setCid(Integer cid) { this.cid = cid; }
    public void setGrade(grade_t grade) { this.grade = grade; }
}
