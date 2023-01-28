package com.example.Spring.MongoDB.repository;

import com.example.Spring.MongoDB.models.VoterCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VoterRepository extends MongoRepository<VoterCard,Integer> {
    public VoterCard findFirstById(int id);
}
