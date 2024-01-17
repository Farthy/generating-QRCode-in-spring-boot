package com.farthy.QRcode.service;

import com.farthy.QRcode.model.Student;
import com.farthy.QRcode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getStudents(){
      return  repository.findAll();
    }
    public Student addStudent(Student student){
        return repository.save(student);
    }
    public Student findById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));

    }
}
