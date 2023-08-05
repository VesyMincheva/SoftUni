package com.example.springintrolab;

import com.example.springintrolab.entities.Student;
import com.example.springintrolab.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private StudentService studentService;

    public ConsoleRunner(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws   Exception {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();

        Student register = studentService.register(studentName);
        Student student = studentService.searchByName(studentName);

        System.out.println(student.getId());
    }
}
