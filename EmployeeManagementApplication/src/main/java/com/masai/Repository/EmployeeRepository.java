package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
