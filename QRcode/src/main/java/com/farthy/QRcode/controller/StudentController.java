package com.farthy.QRcode.controller;

import com.farthy.QRcode.model.Student;
import com.farthy.QRcode.service.StudentService;
import com.farthy.QRcode.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() throws IOException, WriterException {
        List<Student> students = service.getStudents();
        if (students.size()!=0){
            for (Student student: students){
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(service.getStudents());
    }
    @PostMapping
    public Student  addStudent(@RequestBody Student student){
      return  service.addStudent(student);
    }
    @GetMapping("/{id}")
     public  Student getStudentById(@PathVariable("id") Long id){
        return service.findById(id);
    }

}
