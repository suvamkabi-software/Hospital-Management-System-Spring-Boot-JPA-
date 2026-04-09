package com.example.Hospital_management.Repositery;

import com.example.Hospital_management.Entity.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Patient_Repositery  extends JpaRepository<patient,Long> {

//    patient findByNameorEmail(String name,String email);//camel case use b -B or n-N
patient findByName(String name);

@Query("SELECT p FROM patient p WHERE p.date > :date")
List<patient> findByDateAfter(@Param("date")LocalDate date);
//
//@Query(value = "SELECT * FROM patient",nativeQuery = true)
//List<patient> findAllByPatients();

    @Query(value = "SELECT * FROM patient",nativeQuery = true)
    Page<patient> findAllByPatients(Pageable pageable);



}
