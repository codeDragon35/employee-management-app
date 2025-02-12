package com.codeDragon35.employee_service.service;


import com.codeDragon35.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("v1/departments/get/{departmentCode}")
    DepartmentDTO getDepartmentByDepartmentCode(@PathVariable(name="departmentCode") String code);
}
