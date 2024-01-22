package com.pranavbale.mapping.repository;

import com.pranavbale.mapping.entity.Student;
import com.pranavbale.mapping.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> getAllByTeachers(Teacher teacher);
}
