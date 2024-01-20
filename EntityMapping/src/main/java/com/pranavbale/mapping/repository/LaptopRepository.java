package com.pranavbale.mapping.repository;

import com.pranavbale.mapping.entity.Laptop;
import com.pranavbale.mapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, UUID> {
    Laptop findByStudent(Student student);
}
