package com.codeDragon35.employee_service.repository;

import com.codeDragon35.employee_service.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
