package com.farthy.QRcode.repository;

import com.farthy.QRcode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
