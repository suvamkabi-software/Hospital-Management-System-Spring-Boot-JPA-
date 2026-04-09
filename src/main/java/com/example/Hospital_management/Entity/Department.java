package com.example.Hospital_management.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @OneToOne
    private  Docter headdocter;

    @ManyToMany
    //@JoinTable(name = "")
    private Set<Docter> docters=new HashSet<>();

}
