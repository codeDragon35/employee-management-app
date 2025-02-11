package com.codeDragon35.employee_service.controller;


import com.codeDragon35.employee_service.dto.ApiResponseDTO;
import com.codeDragon35.employee_service.dto.EmployeeDTO;
import com.codeDragon35.employee_service.service.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployeeDTO = employeeServiceInterface.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ApiResponseDTO> getEmployeeById(@PathVariable Long id){
        ApiResponseDTO apiResponseDTO = employeeServiceInterface.getEmployee(id);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
