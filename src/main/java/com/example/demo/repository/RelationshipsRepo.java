package com.example.demo.repository;

import com.example.demo.domain.model.Relationships;
import com.example.demo.domain.model.RelationshipsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipsRepo extends JpaRepository<Relationships, RelationshipsId> {

}
