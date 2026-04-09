package com.example.Hospital_management.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Docter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false,length = 50)
    private String  name;

    @Column(length = 100)
    private String specialization;


    @Column(nullable = false,unique = true,length = 100)
    private  String email;

    @ManyToMany(mappedBy = "docters")
    private Set<Department>departments =new HashSet<>();
}
