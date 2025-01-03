package com.gl.EmpManagment.service;

import com.gl.EmpManagment.security.entity.Role;
import com.gl.EmpManagment.security.entity.User;

public interface UserService {

	public User save(User user);
	public Role save(Role role);
}
