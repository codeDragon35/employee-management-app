package com.codeDragon35.department_service.mapper;

import com.codeDragon35.department_service.dto.DepartmentDTO;
import com.codeDragon35.department_service.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDTO mapToDepartmentDTO(DepartmentEntity departmentEntity);
    DepartmentEntity mapToDepartmentEntity(DepartmentDTO departmentDTO);

}
