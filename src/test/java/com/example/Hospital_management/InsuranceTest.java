package com.example.Hospital_management;


import com.example.Hospital_management.Entity.Appointment;
import com.example.Hospital_management.Entity.Insurance;
import com.example.Hospital_management.Entity.patient;
import com.example.Hospital_management.Service.AppointmentService;
import com.example.Hospital_management.Service.InsuranceService;
import jakarta.transaction.Transactional;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;
    @Test
    public  void TestInsurance(){
        Insurance insurance=Insurance.builder()
                .policynumber("HDFC _1235")
                .provider("HDFC")
                .validuntil(LocalDate.of(2030,12,5))
                .build();

        patient patient=insuranceService.assignInsuranceTopatient(insurance,2l);
        System.out.println(patient);
       var newpatient= insuranceService.removepation(patient.getId());
        System.out.println(newpatient);
    }
    @Test
    public  void  testAppointment(){
Appointment appointment= Appointment.builder()
        .appointmentTime(LocalDateTime.of(2025,11,1,14,25))
        .reason("Cnacer").build();
var newappointment=appointmentService.createNewAppointment(appointment,1l,2l);
        System.out.println(newappointment);
    }

}
