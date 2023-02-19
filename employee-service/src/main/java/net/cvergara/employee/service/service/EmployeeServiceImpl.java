package net.cvergara.employee.service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.cvergara.employee.service.dto.APIResponseDTO;
import net.cvergara.employee.service.dto.DepartmentDto;
import net.cvergara.employee.service.dto.EmployeeDto;
import net.cvergara.employee.service.dto.OrganizationDto;
import net.cvergara.employee.service.entity.Employee;
import net.cvergara.employee.service.exception.ResourceNotFoundException;
import net.cvergara.employee.service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class );
    private EmployeeRepository employeeRepository ;
    private ModelMapper modelMapper ;

   // private RestTemplate restTemplate ;
    private WebClient webClient ;
    private APIClient apiClient ;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = modelMapper.map(employeeDto , Employee.class) ;
        employeeRepository.save(savedEmployee) ;
        return modelMapper.map(savedEmployee , EmployeeDto.class) ;
    }

  // @CircuitBreaker(name = "${spring.application.name}" , fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}" , fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById method") ;
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException ("Employee" , "id" , employeeId) )  ;


//        ResponseEntity <DepartmentDto> responseEntity= restTemplate
//                .getForEntity("http://localhost:8080/api/departments/"
//                        + employee.getDepartmentCode() , DepartmentDto.class) ;
        // DepartmentDto departmentDto = responseEntity.getBody() ;

       DepartmentDto departmentDto =  webClient.get()
                                        .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                                        .retrieve()
                                        .bodyToMono(DepartmentDto.class)
                                        .block() ;

          // DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode()) ;

         OrganizationDto organizationDto = webClient.get().uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                 .retrieve()
                 .bodyToMono(OrganizationDto.class)
                 .block() ;

           EmployeeDto employeeDto = modelMapper.map(employee , EmployeeDto.class);
           APIResponseDTO apiResponseDTO =  new APIResponseDTO() ;

         apiResponseDTO.setDepartment(departmentDto);
         apiResponseDTO.setEmployee(employeeDto);
         apiResponseDTO.setOrganization(organizationDto);

         return apiResponseDTO ;

        //return modelMapper.map(employee , EmployeeDto.class);

    }

    public APIResponseDTO getDefaultDepartment(Long employeeId , Exception exception) {

        LOGGER.info("inside getDefaultDepartment method") ;
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException ("Employee" , "id" , employeeId) )  ;


        DepartmentDto departmentDto =  new DepartmentDto() ;
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("RESEARCH AND DEVELOPMENT");

        EmployeeDto employeeDto = modelMapper.map(employee , EmployeeDto.class);
        APIResponseDTO apiResponseDTO =  new APIResponseDTO() ;

        apiResponseDTO.setDepartment(departmentDto);
        apiResponseDTO.setEmployee(employeeDto);

        return apiResponseDTO ;

    }

}
