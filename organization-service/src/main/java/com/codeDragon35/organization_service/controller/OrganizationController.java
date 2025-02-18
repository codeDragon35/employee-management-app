package com.codeDragon35.organization_service.controller;

import com.codeDragon35.organization_service.dto.OrganizationDTO;
import com.codeDragon35.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/organization")
@AllArgsConstructor
public class OrganizationController {


    private OrganizationService organizationService;

    @PostMapping("save")
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO){
       return new ResponseEntity<>(organizationService.saveOrganization(organizationDTO), HttpStatus.CREATED);
    }

    @GetMapping("get/{code}")
     public ResponseEntity<OrganizationDTO> getOrganizationByCode(@PathVariable String code){
        return new ResponseEntity<>(organizationService.getOrganizationByCode(code), HttpStatus.OK);
    }
}
