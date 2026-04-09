package com.example.Hospital_management.Service;


import com.example.Hospital_management.Entity.Insurance;
import com.example.Hospital_management.Entity.patient;
import com.example.Hospital_management.Repositery.Patient_Repositery;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final Patient_Repositery patientRepositery;

    @Transactional
    public patient assignInsuranceTopatient(Insurance insurance, long patientId) {
        patient patient=patientRepositery.findById(patientId).orElseThrow(()->new EntityNotFoundException("patient not found  with id:"+patientId));
       patient.setInsurance(insurance);
       insurance.setPatient(patient);
      return patient;

    }
    @Transactional
    public  patient  removepation(Long patientId){
        patient patient=patientRepositery.findById(patientId).orElseThrow(()->
                new EntityNotFoundException("patient not found  with id:"+patientId));
        patient.setInsurance(null);
        return  patient;
    }

}
