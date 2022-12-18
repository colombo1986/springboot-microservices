package net.cvergara.employee.service.controller;

import lombok.AllArgsConstructor;
import net.cvergara.employee.service.dto.APIResponseDTO;
import net.cvergara.employee.service.dto.EmployeeDto;
import net.cvergara.employee.service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService ;

    //build save employee Rest Api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee =employeeService.saveEmployee(employeeDto) ;
       return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED) ;

    }

    //build get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId) ;
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK) ;
    }
}
