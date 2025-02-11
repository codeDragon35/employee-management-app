package com.codeDragon35.employee_service.service.impl;

import com.codeDragon35.employee_service.dto.ApiResponseDTO;
import com.codeDragon35.employee_service.dto.DepartmentDTO;
import com.codeDragon35.employee_service.dto.EmployeeDTO;
import com.codeDragon35.employee_service.entity.EmployeeEntity;
import com.codeDragon35.employee_service.repository.EmployeeRepository;
import com.codeDragon35.employee_service.service.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
//    private RestTemplate restTemplate;
    private WebClient webClient;

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
    public ApiResponseDTO getEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        EmployeeDTO  employeeDTO = modelMapper.map(employeeEntity, EmployeeDTO.class);
        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/v1/departments/"+employeeEntity.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDTO.class).block();

//        ResponseEntity<DepartmentDTO> responseEntity =  restTemplate.getForEntity("http://localhost:8080/v1/departments/"+employeeEntity.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
//        return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getFirstName(),employeeEntity.getLastName(),employeeEntity.getEmail());
        return apiResponseDTO;
    }
}
