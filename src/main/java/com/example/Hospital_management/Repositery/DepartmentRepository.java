package com.example.Hospital_management.Repositery;

import com.example.Hospital_management.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}