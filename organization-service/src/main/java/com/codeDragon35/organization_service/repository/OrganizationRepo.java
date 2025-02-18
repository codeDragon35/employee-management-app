package com.codeDragon35.organization_service.repository;

import com.codeDragon35.organization_service.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
