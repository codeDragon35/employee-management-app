package com.codeDragon35.organization_service.service;

import com.codeDragon35.organization_service.dto.OrganizationDTO;

public interface OrganizationService {

    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO getOrganizationByCode(String organizationCode);

}
