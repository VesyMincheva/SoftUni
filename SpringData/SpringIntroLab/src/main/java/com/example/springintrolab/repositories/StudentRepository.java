package com.example.springintrolab.repositories;

import com.example.springintrolab.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByName(String name);


}
