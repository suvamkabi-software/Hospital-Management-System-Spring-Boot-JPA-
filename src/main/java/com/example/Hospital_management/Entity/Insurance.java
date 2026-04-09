package com.example.Hospital_management.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String policynumber;


    @Column(nullable = false, length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate validuntil;

    @CreationTimestamp
    @Column(nullable = false, unique = false)
    private LocalDate createdat;

    @OneToOne(mappedBy = "insurance")
     private  patient patient;

}

