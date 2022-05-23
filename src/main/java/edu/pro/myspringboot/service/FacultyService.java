package edu.pro.myspringboot.service;

import edu.pro.myspringboot.model.Faculty;
import edu.pro.myspringboot.model.NameOfFaculty;
import edu.pro.myspringboot.repository.FacultyMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FacultyService {

    private List<Faculty> faculties = new ArrayList<>(
            Arrays.asList(
                    new Faculty("0", "CHNU",
                            NameOfFaculty.IST, 40,
                            "need more student",
                            LocalDateTime.now(), LocalDateTime.now()),
                    new Faculty("1", "CHNU",
                            NameOfFaculty.SSP, 40,
                            "need more student",
                            LocalDateTime.now(), LocalDateTime.now()),
                    new Faculty("CHNU",
                            NameOfFaculty.IST, 40,
                            "need more student",
                            LocalDateTime.now(), null)
            )
    );

    @Autowired
    FacultyMongoRepository repository;

    //@PostConstruct
    void init() {
        repository.saveAll(faculties);
    }

    public List<Faculty> getAll() {
        return repository.findAll();
    }

    public Faculty getById(String id) {
        return repository.findById(id).orElseThrow(() -> new ExpressionException("Not found id"));
    }

    public Faculty create(Faculty faculty) {
        faculty.setCreatAt(LocalDateTime.now());
        return repository.save(faculty);
    }

    public Faculty update(Faculty faculty) {
        faculty.setUpdateAt(LocalDateTime.now());
        repository.save(faculty);
        return faculty;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
