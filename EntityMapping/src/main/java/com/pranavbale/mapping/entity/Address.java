package com.pranavbale.mapping.entity;

import jakarta.persistence.*;
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
public class Address {

    @Id
    @GeneratedValue
    private UUID addressId;
    private String address;

    // Many to One mapping

    @ManyToOne(cascade = CascadeType.ALL)       // perform same operation on child
    @JoinColumn(name = "student")
    private Student student;
}
