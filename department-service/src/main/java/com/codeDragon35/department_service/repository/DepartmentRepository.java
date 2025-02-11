package com.codeDragon35.department_service.repository;

import com.codeDragon35.department_service.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>
{
    Optional<DepartmentEntity> findByDepartmentCode(String departmentCode);
}
