package com.gl.EmpManagment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.EmpManagment.repository.RoleRepository;
import com.gl.EmpManagment.repository.UserRepository;
import com.gl.EmpManagment.security.entity.Role;
import com.gl.EmpManagment.security.entity.User;
import com.gl.EmpManagment.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public User save(User user) {
	
		return userRepo.save(user);
	}
	
    public List<User> getSortedEmployees(String order) {
        List<User> employees = userRepo.findAll();
        if ("asc".equalsIgnoreCase(order)) {
            return employees.stream()
                            .sorted((u1, u2) -> u1.getFirstName().compareToIgnoreCase(u2.getFirstName()))
                            .collect(Collectors.toList());
        } else if ("desc".equalsIgnoreCase(order)) {
            return employees.stream()
                            .sorted((u1, u2) -> u2.getFirstName().compareToIgnoreCase(u1.getFirstName()))
                            .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }
    }

	@Override
	public Role save(Role role) {
		return roleRepo.save(role);
	}

}
