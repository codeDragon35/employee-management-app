package com.codeDragon35.employee_service.service;

import com.codeDragon35.employee_service.dto.EmployeeDTO;

public interface EmployeeServiceInterface {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(Long id);
}

