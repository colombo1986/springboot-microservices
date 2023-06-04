package net.cvergara.employee.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(description = "EmployeeDto Model information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id ;
    @Schema(description = "Employee first name")
    private String firstName ;
    @Schema(description = "Employee last name")
    private String lastName ;
    @Schema(description = "Employee email")
    private String email ;
    @Schema(description = "Employee department code")
    private String departmentCode ;
    @Schema(description = "Employee organization code")
    private String organizationCode ;
}
