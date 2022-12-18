package net.cvergara.employee.service.service;

import lombok.AllArgsConstructor;
import net.cvergara.employee.service.dto.APIResponseDTO;
import net.cvergara.employee.service.dto.DepartmentDto;
import net.cvergara.employee.service.dto.EmployeeDto;
import net.cvergara.employee.service.entity.Employee;
import net.cvergara.employee.service.exception.ResourceNotFoundException;
import net.cvergara.employee.service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository ;
    private ModelMapper modelMapper ;

   // private RestTemplate restTemplate ;
    //private WebClient webClient ;
    private APIClient apiClient ;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = modelMapper.map(employeeDto , Employee.class) ;
        employeeRepository.save(savedEmployee) ;
        return modelMapper.map(savedEmployee , EmployeeDto.class) ;
    }

    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException ("Employee" , "id" , employeeId) )  ;


//        ResponseEntity <DepartmentDto> responseEntity= restTemplate
//                .getForEntity("http://localhost:8080/api/departments/"
//                        + employee.getDepartmentCode() , DepartmentDto.class) ;
        // DepartmentDto departmentDto = responseEntity.getBody() ;

//       DepartmentDto departmentDto =  webClient.get()
//                                        .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                                        .retrieve()
//                                        .bodyToMono(DepartmentDto.class)
//                                        .block() ;

           DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode()) ;
           EmployeeDto employeeDto = modelMapper.map(employee , EmployeeDto.class);
           APIResponseDTO apiResponseDTO =  new APIResponseDTO() ;

         apiResponseDTO.setDepartment(departmentDto);
         apiResponseDTO.setEmployeeDto(employeeDto);

         return apiResponseDTO ;

        //return modelMapper.map(employee , EmployeeDto.class);

    }


}