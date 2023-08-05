package com.example.springintrolab.services;

import com.example.springintrolab.entities.Student;

public interface StudentService {

    Student register (String name);

    Student searchByName(String name);
}
