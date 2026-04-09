package com.example.Hospital_management.Service;


import com.example.Hospital_management.Entity.Appointment;
import com.example.Hospital_management.Entity.Docter;
import com.example.Hospital_management.Entity.patient;
import com.example.Hospital_management.Repositery.AppointmentRepository;
import com.example.Hospital_management.Repositery.DocterRepository;
import com.example.Hospital_management.Repositery.Patient_Repositery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private  final AppointmentRepository appointmentRepository;
    private  final DocterRepository docterRepository;
    private final Patient_Repositery patientRepositery;

    @Transactional
    public  Appointment  createNewAppointment(Appointment appointment,long docterid,long patienId){
        Docter docter=docterRepository.findById(docterid).orElseThrow(() ->
                new IllegalArgumentException("Doctor not found"));

        patient patient=patientRepositery.findById(patienId).
                orElseThrow(() -> new IllegalArgumentException("Patient not found"));


        if (appointment.getId() != null)
            throw new IllegalArgumentException("Appointment should not have ID");

        appointment.setPatient(patient);
        appointment.setDocter(docter);
        patient.getAppointments().add(appointment);

       return appointmentRepository.save(appointment);
    }

    @Transactional
    public  Appointment ressignAppointmentToAnotherDocter(Long appintmentId,Long docterId){
        Appointment appointment=appointmentRepository.findById(appintmentId).orElseThrow();
        Docter docter=docterRepository.findById(docterId).orElseThrow();
        appointment.setDocter(docter);
        return appointment;
    }

}
