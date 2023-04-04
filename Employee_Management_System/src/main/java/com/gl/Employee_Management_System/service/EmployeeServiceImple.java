package com.gl.Employee_Management_System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.Employee_Management_System.dao.EmployeeRepository;
import com.gl.Employee_Management_System.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {

	EmployeeRepository employeeRepository;
	
	public EmployeeServiceImple(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee Employee=employeeRepository.findById(id).get();
		if(Employee==null) {
			throw new RuntimeException("did not find employee id"+id);
		}
		else {
		return Employee;
		}
	}

	@Override
	public Employee updateEmployee(Employee Employee) {
		
		return employeeRepository.save(Employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
