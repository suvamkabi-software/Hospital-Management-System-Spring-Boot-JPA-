package com.example.Hospital_management.Repositery;

import com.example.Hospital_management.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}