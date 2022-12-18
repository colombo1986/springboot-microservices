package net.cvergara.department.service.service;

import lombok.AllArgsConstructor;
import net.cvergara.department.service.dto.DepartmentDto;
import net.cvergara.department.service.entity.Department;
import net.cvergara.department.service.exception.ResourceNotFoundException;
import net.cvergara.department.service.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository ;
    private ModelMapper modelMapper  ;

    @Override
    public DepartmentDto saveDepartmentDto(DepartmentDto departmentDto) {
        //Convert departmentDto to DepartmentJpa entity
        Department savedDepartment =  modelMapper.map(departmentDto , Department.class) ;
        departmentRepository.save(savedDepartment) ;
        return modelMapper.map(savedDepartment , DepartmentDto.class);

    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(departmentCode) ;
        if(optionalDepartment.isEmpty()){
            throw new ResourceNotFoundException("Department" , "id" , departmentCode) ;
        }
        return modelMapper.map(optionalDepartment.get() , DepartmentDto.class);
    }


}
