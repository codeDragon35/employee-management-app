package com.codeDragon35.employee_service.service.impl;

import com.codeDragon35.employee_service.dto.EmployeeDTO;
import com.codeDragon35.employee_service.entity.EmployeeEntity;
import com.codeDragon35.employee_service.repository.EmployeeRepository;
import com.codeDragon35.employee_service.service.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
//        EmployeeEntity employeeEntity = new EmployeeEntity(employeeDTO.getId(), employeeDTO.getFirstName(),employeeDTO.getLastName(),employeeDTO.getEmail());
//        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
//        return new EmployeeDTO(savedEmployee.getId(),savedEmployee.getFirstName(),savedEmployee.getLastName(),savedEmployee.getEmail());

            EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
            EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
            return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

//        return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getFirstName(),employeeEntity.getLastName(),employeeEntity.getEmail());
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
}
