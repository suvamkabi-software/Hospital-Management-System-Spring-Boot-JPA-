package com.example.Hospital_management.Service;


import com.example.Hospital_management.Entity.patient;
import com.example.Hospital_management.Repositery.Patient_Repositery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private  final Patient_Repositery patientRepositery;

    @Transactional
    public patient getpatientbyid(long id){
        patient p1=patientRepositery.findById(id).orElseThrow();
        patient p2=patientRepositery.findById(id).orElseThrow();
        System.out.println(p1);
        //p1.setEmail("suvamsahu@gmail.com");
        return p1;
    }

}
