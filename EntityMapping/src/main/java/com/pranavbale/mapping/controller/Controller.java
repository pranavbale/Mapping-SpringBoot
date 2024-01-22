package com.pranavbale.mapping.controller;

import com.pranavbale.mapping.entity.*;
import com.pranavbale.mapping.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/addAddress")
    private Address saveAddress(@RequestBody Address address) {
        return  service.saveAddress(address);
    }

    @GetMapping("/getAddress/{addressId}")
    private Address getAddress(@PathVariable UUID addressId) {
        return  service.getAddress(addressId);
    }

    @GetMapping("/getAddressByStudentId/{studentId}")
    private List<Address> getAddressesByStudentId( @PathVariable UUID studentId) {
        return  service.getAddressesByStudentId(studentId);
    }

    @PostMapping("/addTeacher")
    private Teacher addTeacher(@RequestBody Teacher teacher) {
        return  service.saveTeacher(teacher);
    }

    @GetMapping("/getTeacher/{teacherId}")
    private Teacher getTeacher(@PathVariable UUID teacherId) {
        return service.getTeacher(teacherId);
    }

    @GetMapping("/getTeacherByStudentId/{studentId}")
    private List<Teacher> getTeacherByStudentId(@PathVariable UUID studentId) {
        return service.getTeacherByStudentId(studentId);
    }

    @GetMapping("/getStudentByTeacherId/{teacherId}")
    private List<Student> getStudentByTeacherId(@PathVariable UUID teacherId) {
        return  service.getStudentByTeacherId(teacherId);
    }

    @PutMapping("/setStudentsToTeacher/{teacherId}")
    private String setStudentsToTeacher(@PathVariable UUID teacherId, @RequestBody UUIDRequest studentIds) {
        return service.setStudents(teacherId, studentIds);
    }

    @PutMapping("/SetTeachersToStudent/{studentId}")
    private String setTeachersToStudent(@PathVariable UUID studentId, @RequestBody UUIDRequest teacherIds) {
        return  service.setTeachers(studentId, teacherIds);
    }

    @GetMapping("/getAllStudent")
    private List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/getAllTeachers")
    private List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }

    @GetMapping("/getAllLaptops")
    private List<Laptop> getAllLaptops() {
        return service.getAllLaptops();
    }

    @GetMapping("/getAllAddresses")
    private List<Address> getAllAddresses() {
        return service.getAllAddress();
    }
}
