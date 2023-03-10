package net.cvergara.department.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName ;
    private String fieldName ;
    private String departmentCode ;

    public ResourceNotFoundException(String resourceName , String fieldName , String departmentCode){
        super(String.format("%s not found with %s : '%s'", resourceName , fieldName , departmentCode)) ;
        this.resourceName = resourceName ;
        this.fieldName = fieldName ;
        this.departmentCode = departmentCode ;

    }

}
