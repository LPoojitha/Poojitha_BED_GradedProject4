package com.gl.EmpManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmpManagment.entity.Employee;
import com.gl.EmpManagment.security.entity.Role;
import com.gl.EmpManagment.security.entity.User;
import com.gl.EmpManagment.service.EmployeeService;
import com.gl.EmpManagment.service.UserService;

@RestController
public class EmployeeControlller {

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

	/*
	 * { "username":"temp", "password":"12345", "roles":[{ "id":2, "name":"USER" }]
	 * }
	 */

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {

		User user1 = userService.save(user);
		return "User added Successfully with user id " + user1.getId();
	}

	/*
	 * { "name":"HR" }
	 */

	@PostMapping("/addRole")
	public String addRole(@RequestBody Role role) {

		Role role1 = userService.save(role);
		return "Role add Successfully with role id " + role1.getId();
	}

	@PostMapping("/addEmployee")
	public String addRole(@RequestBody Employee employee) {

		Employee employee2 = employeeService.addEmployee(employee);
		return "Employee add Successfully with role id " + employee2.getId();
	}

	@GetMapping("/listEmployee")
	public List<Employee> listEmployee() {
		return employeeService.listEmployee();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return "Deleted employee id - " + id;
	}

	@GetMapping("/search/{firstName}")
	public List<Employee> getEmployeesByFirstName(@PathVariable String firstName) {
		return employeeService.getEmployeesByFirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> listEmployeesSorted(@RequestParam String order) {
		return employeeService.listEmployeesSorted(order);
	}
}
