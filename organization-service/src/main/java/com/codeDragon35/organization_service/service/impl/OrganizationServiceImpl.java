package com.codeDragon35.organization_service.service.impl;

import com.codeDragon35.organization_service.dto.OrganizationDTO;
import com.codeDragon35.organization_service.entity.Organization;
import com.codeDragon35.organization_service.mapper.OrganizationMapper;
import com.codeDragon35.organization_service.repository.OrganizationRepo;
import com.codeDragon35.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepo organizationRepo;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        Organization organization = OrganizationMapper.mapToEntity(organizationDTO);
        Organization savedOrganization = organizationRepo.save(organization);
        return OrganizationMapper.mapToDto(savedOrganization);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization savedOrganization = organizationRepo.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToDto(savedOrganization);
    }
}
