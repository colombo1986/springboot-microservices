package net.cvergara.employee.service.repository;

import net.cvergara.employee.service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository <Employee , Long> {

    Optional<Employee> findById(Long id) ;
}
