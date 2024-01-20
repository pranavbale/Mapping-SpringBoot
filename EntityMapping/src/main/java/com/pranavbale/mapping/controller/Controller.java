package com.pranavbale.mapping.controller;

import com.pranavbale.mapping.entity.Laptop;
import com.pranavbale.mapping.entity.Student;
import com.pranavbale.mapping.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/mapping")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/addStudent")
    private Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PostMapping("/addLaptop")
    private Laptop saveLaptop(@RequestBody Laptop laptop) {
        return  service.saveLaptop(laptop);
    }

    @GetMapping("getLaptop/{laptopId}")
    private Laptop getLaptop(@PathVariable UUID laptopId) {
        return service.getLaptop(laptopId);
    }

    @GetMapping("/getStudent/{studentId}")
    private Student getStudent(@PathVariable UUID studentId) {
        return  service.getStudent(studentId);
    }

    @GetMapping("/getLaptopByStudentId/{studentId}")
    private Laptop getLaptopByStudentId(@PathVariable UUID studentId) {
        return service.getLaptopByStudentId(studentId);
    }


}
