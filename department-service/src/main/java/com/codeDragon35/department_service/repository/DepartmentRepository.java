package com.codeDragon35.department_service.repository;

import com.codeDragon35.department_service.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>
{
    DepartmentEntity findByDepartmentCode(String departmentCode);
}
