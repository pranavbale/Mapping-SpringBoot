package com.pranavbale.mapping.service;

import com.pranavbale.mapping.entity.*;
import com.pranavbale.mapping.repository.AddressRepository;
import com.pranavbale.mapping.repository.LaptopRepository;
import com.pranavbale.mapping.repository.StudentRepository;
import com.pranavbale.mapping.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TeacherRepository teacherRepository;


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

    // One to many and Many-to-One relationship

    public Address saveAddress(Address address) {
        address.setStudent(studentRepository.findById(address.getStudent().getStudentId()).get());
        return addressRepository.save(address);
    }

    public Address getAddress(UUID addressId) {
        return addressRepository.findById(addressId).get();
    }

    public List<Address> getAddressesByStudentId(UUID studentId) {
        return addressRepository.getAllByStudent(studentRepository.findById(studentId).get());
    }

    // Many to Many Mapping

    public Teacher saveTeacher(Teacher teacher) {
        return  teacherRepository.save(teacher);
    }

    public Teacher getTeacher(UUID teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

    public List<Student> getStudentByTeacherId(UUID teacherId) {
        return studentRepository.getAllByTeachers(getTeacher(teacherId));
    }

    public  List<Teacher> getTeacherByStudentId(UUID studentId) {
        return teacherRepository.findTeachersByStudentId(studentId);
    }

    public String setStudents (UUID teacherId, UUIDRequest studentId) {
        List<Student> students = studentRepository.findAllById(studentId.getIds());

        Teacher teacher = teacherRepository.findById(teacherId).get();

        teacher.setStudents(students);

        teacherRepository.save(teacher);

        return "Student set Successfully";

    }

    public String setTeachers(UUID studentId, UUIDRequest teacherId) {
        List<Teacher> teachers = teacherRepository.findAllById(teacherId.getIds());

        Student student = studentRepository.findById(studentId).get();

        student.setTeachers(teachers);

        studentRepository.save(student);

        return "Teacher set Successfully";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
