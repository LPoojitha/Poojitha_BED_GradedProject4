package com.gl.EmpManagment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.EmpManagment.entity.Employee;
import com.gl.EmpManagment.repository.EmployeeRepository;
import com.gl.EmpManagment.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();

	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		return optionalEmployee.orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> listEmployeesSorted(String order) {
		Sort sort = order.equalsIgnoreCase("asc") ? Sort.by("firstName").ascending()
				: Sort.by("firstName").descending();
		return employeeRepository.findAll(sort);
	}

}
