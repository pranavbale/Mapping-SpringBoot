package com.pranavbale.mapping.repository;

import com.pranavbale.mapping.entity.Address;
import com.pranavbale.mapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> getAllByStudent(Student student);
}
