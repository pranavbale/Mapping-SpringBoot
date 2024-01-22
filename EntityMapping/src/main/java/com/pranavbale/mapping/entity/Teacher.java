package com.pranavbale.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue
    private UUID teacherId;
    private String teacherName;

    @JsonIgnore
    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;

}
