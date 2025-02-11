package com.codeDragon35.department_service.service;

import com.codeDragon35.department_service.dto.DepartmentDTO;

public interface DepartmentServiceInterface {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentByCode(String departmentCode);
}
