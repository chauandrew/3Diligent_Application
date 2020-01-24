package com.example.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelationshipsId implements Serializable {
    @Column(name="sid")
    private Integer sid;
    @Column(name="gid")
    private Integer gid;

    public RelationshipsId() {}

    public RelationshipsId(Integer studentId, Integer guardianId) {
        this.sid = studentId;
        this.gid = guardianId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipsId that = (RelationshipsId) o;
        return Objects.equals(sid, that.sid) &&
                Objects.equals(gid, that.gid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, gid);
    }
}
