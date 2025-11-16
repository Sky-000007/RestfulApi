package com.restApiFileSystem.RestApiFileSystem.repository;

import com.restApiFileSystem.RestApiFileSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
