package com.example.demo.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Guardians")
public class Guardians {
    @Id
    @Column(name="gid")
    private Integer gid;
    @Column(name="name")
    private String name;

    // Constructors
    public Guardians(){}
    public Guardians(Integer gid, String name) {
        this.gid = gid;
        this.name = name;
    }

    // Getters and setters
    public Integer getGid() {
        return gid;
    }
    public String getName() {
        return name;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public void setName(String name) {
        this.name = name;
    }
}
