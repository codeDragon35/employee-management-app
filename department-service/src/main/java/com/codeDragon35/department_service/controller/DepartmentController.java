package com.codeDragon35.department_service.controller;

import com.codeDragon35.department_service.dto.DepartmentDTO;
import com.codeDragon35.department_service.service.DepartmentServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentServiceInterface departmentServiceInterface;
    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentServiceInterface.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/get/{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepartmentByDepartmentCode(@PathVariable(name="departmentCode") String code){
        DepartmentDTO departmentDTO = departmentServiceInterface.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }


}
