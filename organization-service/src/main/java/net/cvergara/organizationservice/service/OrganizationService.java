package net.cvergara.organizationservice.service;

import net.cvergara.organizationservice.dto.OrganizationDto;
import net.cvergara.organizationservice.entity.Organization;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto) ;

    OrganizationDto getOrganizationByCode(String organizationCode) ;

}
