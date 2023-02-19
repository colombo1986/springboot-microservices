package net.cvergara.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.cvergara.organizationservice.dto.OrganizationDto;
import net.cvergara.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }


    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization( @PathVariable("code") String organizationCode){
       OrganizationDto organizationDto =  organizationService.getOrganizationByCode(organizationCode)  ;
       return ResponseEntity.ok(organizationDto) ;
    }

}
