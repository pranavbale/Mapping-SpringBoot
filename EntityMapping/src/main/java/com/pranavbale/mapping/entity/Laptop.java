package com.pranavbale.mapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue
    private UUID laptopId;
    private String modelNo;
    private String brand;


    // foreign key generated here
//    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "student_id")    // mention the name of the join column
    private Student student;

}
