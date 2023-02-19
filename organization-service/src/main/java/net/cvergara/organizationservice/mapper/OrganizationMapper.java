package net.cvergara.organizationservice.mapper;

import net.cvergara.organizationservice.dto.OrganizationDto;
import net.cvergara.organizationservice.entity.Organization;

import java.time.LocalDateTime;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCeationDate()
         );

        return organizationDto ;

    }

    public static Organization mapToOrganization(OrganizationDto organizationDto){

        Organization organization = new Organization( organizationDto.getId() ,
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription() ,
                organizationDto.getOrganizationCode() ,
                organizationDto.getCreationDate()

        );

        return organization ;


    }



}
