package com.pranavbale.mapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue
    private UUID studentId;
    private String studentName;
    private String about;

    // Laptop table managed a student id
    // mapped by create a only one foreign key otherwise it creat in both the table
    @JsonBackReference      // to doesn't rotate in a circle
    @OneToOne(mappedBy = "student")
    private Laptop laptop;
}
