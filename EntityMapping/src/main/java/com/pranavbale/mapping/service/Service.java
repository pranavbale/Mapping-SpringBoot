package com.pranavbale.mapping.service;

import com.pranavbale.mapping.entity.Laptop;
import com.pranavbale.mapping.entity.Student;
import com.pranavbale.mapping.repository.LaptopRepository;
import com.pranavbale.mapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private StudentRepository studentRepository;


    // one-to-one relationship
    public Laptop saveLaptop(Laptop laptop) {
//        Student st = studentRepository.save(laptop.getStudent());
//        laptop.setStudent(st);
        return laptopRepository.save(laptop);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(UUID studentId) {

        Student st = studentRepository.findById(studentId).get();

//        System.out.println(st.getLaptop());
        return st;
    }

    public Laptop getLaptop(UUID laptopId) {
        return laptopRepository.findById(laptopId).get();
    }

    public Laptop getLaptopByStudentId(UUID studentId) {
        return  laptopRepository.findByStudent(studentRepository.findById(studentId).get());
    }
}
