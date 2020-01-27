package com.example.demo.domain.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="Students")
public class Students {
    @Id @Column(name="sid")
    private Integer sid;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(
        name="Relationships",
        joinColumns = {@JoinColumn(name="sid")},
        inverseJoinColumns={@JoinColumn(name="gid")})
    private Set<Guardians> guardians;

    @ManyToMany
    @JoinTable(
            name="Transcript",
            joinColumns = {@JoinColumn(name="sid")},
            inverseJoinColumns={@JoinColumn(name="cid")})
    private Set<Courses> courses;

    // construtors
    public Students() {}
    public Students(Integer sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    // Getters and setters
    public Integer getSid() { return sid; }
    public String getName() { return name; }
    public Set<Guardians> getGuardians() { return guardians; }
    public void setName(String name) { this.name = name; }
    public void setSid(Integer sid) { this.sid = sid; }
    public void setGuardians(Set<Guardians> guardians) { this.guardians = guardians; }
}
