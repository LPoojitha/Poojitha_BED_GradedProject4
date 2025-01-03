package com.gl.EmpManagment.service;

import java.util.List;

import com.gl.EmpManagment.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> listEmployee();

	public Employee getEmployeeById(Integer id);

	public Employee updateEmployee(Employee employee);

	public void deleteEmployee(Integer id);

	public List<Employee> getEmployeesByFirstName(String firstName);

	public List<Employee> listEmployeesSorted(String order);

}
