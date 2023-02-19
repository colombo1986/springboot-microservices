package net.cvergara.organizationservice.service;

import lombok.AllArgsConstructor;
import net.cvergara.organizationservice.dto.OrganizationDto;
import net.cvergara.organizationservice.entity.Organization;
import net.cvergara.organizationservice.mapper.OrganizationMapper;
import net.cvergara.organizationservice.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository organizationRepository ;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto) ;
        Organization savedOrganization = organizationRepository.save(organization) ;

        return OrganizationMapper.mapToOrganizationDto(savedOrganization) ;

    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode) ;
        return OrganizationMapper.mapToOrganizationDto(organization) ;
    }


}
