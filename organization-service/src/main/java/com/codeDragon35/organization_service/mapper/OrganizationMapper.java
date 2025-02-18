package com.codeDragon35.organization_service.mapper;

import com.codeDragon35.organization_service.dto.OrganizationDTO;
import com.codeDragon35.organization_service.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDTO mapToDto(Organization organization){
        return  new OrganizationDTO(organization.getId(),organization.getOrganizationName(), organization.getOrganizationDescription(), organization.getOrganizationCode(), organization.getOrganizationCreated());
    }

    public static Organization mapToEntity(OrganizationDTO organizationDto){
        return  new Organization(organizationDto.getId(),organizationDto.getOrganizationName(), organizationDto.getOrganizationDescription(), organizationDto.getOrganizationCode(), organizationDto.getOrganizationCreated());
    }
}
