package com.example.Hospital_management.Entity;


import com.example.Hospital_management.type.enumcheck;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
//@Table(name = "patient_table")
public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    //@NonNull
    @Column(nullable = false)
    private String name;
    private LocalDate date;
    @Column(unique = true)
    private  String email;
    //@ToString.Exclude
    @Enumerated(EnumType.STRING)
    private enumcheck gender;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn           //(name = "put name ")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointments=new ArrayList<>();
}
