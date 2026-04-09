package com.example.Hospital_management;


import com.example.Hospital_management.Entity.patient;
import com.example.Hospital_management.Repositery.Patient_Repositery;
import com.example.Hospital_management.Service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class patienttest {

    @Autowired
    private Patient_Repositery patientRepositery;

    @Autowired
    private PatientService patientService;

    @Test
    public  void  Testptient(){
        List<patient> checkspatientdetails=patientRepositery.findAll();
        System.out.println(checkspatientdetails);
    }

    @Test
    public  void  testTransactionmethod(){
   // patient patient=patientService.getpatientbyid(1L);
       // patient patient=patientRepositery.findByName("Eva Martinez");
       // List<patient>patient=patientRepositery.findByDateAfter(LocalDate.of(2001,3,12));
        Page<patient> patient=patientRepositery.findAllByPatients(PageRequest.of(0,2));
        for (patient patient1:patient)
        System.out.println(patient1);
    }
}
