package net.cvergara.department.service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.cvergara.department.service.dto.DepartmentDto;
import net.cvergara.department.service.repository.DepartmentRepository;
import net.cvergara.department.service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
       name = "Department Controller" ,
       description = "Department Controller exposes REST API"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService ;
    private final DepartmentRepository departmentRepository;

    //build save department Rest Api ;
   @Operation(summary = "Save department Rest API" , description = "Save department Rest API")
   @ApiResponse(responseCode = "201" , description = "HTTP STATUS 201 CREATED")
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartmentDto(departmentDto) ;
        return new ResponseEntity<>(savedDepartment , HttpStatus.CREATED) ;
    }

    //Build get Department Rest Api ;
    @Operation(summary = "GET department Rest API" , description = "GET department Rest API OBJECT FROM DB")
    @ApiResponse(responseCode = "200" , description = "HTTP STATUS 200 SUCCES")
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>( departmentDto, HttpStatus.OK)  ;
    }
}
