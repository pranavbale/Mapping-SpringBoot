package com.pranavbale.mapping.repository;

import com.pranavbale.mapping.entity.Student;
import com.pranavbale.mapping.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    @Query("SELECT t FROM Teacher t JOIN t.students s WHERE s.studentId = :studentId")
    List<Teacher> findTeachersByStudentId(@Param("studentId") UUID studentId);
}
