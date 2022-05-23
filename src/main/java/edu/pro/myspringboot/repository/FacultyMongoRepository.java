package edu.pro.myspringboot.repository;

import edu.pro.myspringboot.model.Faculty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyMongoRepository extends MongoRepository<Faculty, String> {
}
