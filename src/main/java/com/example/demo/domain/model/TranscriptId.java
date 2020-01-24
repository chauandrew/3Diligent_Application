package com.example.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TranscriptId implements Serializable {
    @Column(name="sid")
    private Integer sid;
    @Column(name="cid")
    private Integer cid;

    public TranscriptId(){}

    public TranscriptId(Integer studentId, Integer courseId) {
        this.sid = studentId;
        this.cid = courseId;
    }

    public Integer getSid() { return sid; }
    public Integer getCid() { return cid; }
    public void setSid(Integer sid) { this.sid = sid; }
    public void setCid(Integer cid) { this.cid = cid; }
}
