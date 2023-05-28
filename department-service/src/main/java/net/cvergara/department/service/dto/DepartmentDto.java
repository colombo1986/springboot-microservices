package net.cvergara.department.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DEPARTMENT DTO MODEL INFORMATION" 

)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id ;
    @Schema(description = "department name")
    private String departmentName ;
    @Schema(description = "department description")
    private String departmentDescription ;
    @Schema(description = "department code")
    private String departmentCode ;
}
