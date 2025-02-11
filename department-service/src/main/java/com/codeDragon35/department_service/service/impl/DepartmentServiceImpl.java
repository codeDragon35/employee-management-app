package com.codeDragon35.department_service.service.impl;

import com.codeDragon35.department_service.dto.DepartmentDTO;
import com.codeDragon35.department_service.entity.DepartmentEntity;
import com.codeDragon35.department_service.mapper.DepartmentMapper;
import com.codeDragon35.department_service.repository.DepartmentRepository;
import com.codeDragon35.department_service.service.DepartmentServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentServiceInterface {

    private DepartmentRepository departmentRepository;



    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        //convert DepartmentDTO to DepartmentEntity
//        DepartmentEntity departmentEntity = new DepartmentEntity(departmentDTO.getId(), departmentDTO.getDepartmentName(),departmentDTO.getDepartmentDescription(), departmentDTO.getDepartmentCode());
//        DepartmentEntity savedDepartmentEntity  = departmentRepository.save(departmentEntity);
//        return new DepartmentDTO(savedDepartmentEntity.getId(),savedDepartmentEntity.getDepartmentName(),savedDepartmentEntity.getDepartmentDescription(), savedDepartmentEntity.getDepartmentCode());
        DepartmentEntity departmentEntity = DepartmentMapper.MAPPER.mapToDepartmentEntity(departmentDTO);
        DepartmentEntity savedDepartmentEntity  = departmentRepository.save(departmentEntity);
        return DepartmentMapper.MAPPER.mapToDepartmentDTO(savedDepartmentEntity);

    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        DepartmentEntity department =  departmentRepository.findByDepartmentCode(departmentCode);
//        return new DepartmentDTO(department.getId(), department.getDepartmentName(),department.getDepartmentDescription(), department.getDepartmentCode());
        return DepartmentMapper.MAPPER.mapToDepartmentDTO(department);
    }
}
