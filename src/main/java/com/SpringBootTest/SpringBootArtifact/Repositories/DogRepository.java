package com.SpringBootTest.SpringBootArtifact.Repositories;

import com.SpringBootTest.SpringBootArtifact.Models.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogRepository extends MongoRepository<Dog, String> {
}
