package com.example.demo.domain.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name="Relationships")
@IdClass(RelationshipsId.class)
public class Relationships {
    @Id @Column(name="sid")
    private Integer sid;

    @Id @Column(name="gid")
    private Integer gid;

    // Getters and setters
    public Integer getGid() {
        return gid;
    }
    public Integer getSid() {
        return sid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
