package com.pranavbale.mapping.service;

import com.pranavbale.mapping.entity.Address;
import com.pranavbale.mapping.entity.Laptop;
import com.pranavbale.mapping.entity.Student;
import com.pranavbale.mapping.repository.AddressRepository;
import com.pranavbale.mapping.repository.LaptopRepository;
import com.pranavbale.mapping.repository.StudentRepository;
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

}
