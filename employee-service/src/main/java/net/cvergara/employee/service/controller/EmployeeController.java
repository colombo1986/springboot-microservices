package net.cvergara.employee.service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.cvergara.employee.service.dto.APIResponseDTO;
import net.cvergara.employee.service.dto.EmployeeDto;
import net.cvergara.employee.service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
       name="Employee Service - EmployeeController",
       description = "EmployeeController Exposes REST Apis for Employee Service"
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService ;

    //build save employee Rest Api
    @Operation( summary = "Save employee REST API", description = "Save employee object to database")
    @ApiResponse(responseCode = "201", description = "HTTP STATUS 201 Created")
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee =employeeService.saveEmployee(employeeDto) ;
       return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED) ;

    }

    //build get employee REST API
    @Operation( summary = "GET employee REST API", description = "GET employee object from database")
    @ApiResponse(responseCode = "200", description = "HTTP STATUS 200 OK")
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId) ;
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK) ;
    }
}
