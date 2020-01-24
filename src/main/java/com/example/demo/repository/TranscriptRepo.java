package com.example.demo.repository;

import com.example.demo.domain.model.Transcript;
import com.example.demo.domain.model.TranscriptId;
import com.example.demo.domain.model.grade_t;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranscriptRepo extends JpaRepository<Transcript, TranscriptId> {
    public List<Transcript> findByGradeAndCid(grade_t grade, Integer cid);
    public List<Transcript> findByCid(Integer cid);
}
