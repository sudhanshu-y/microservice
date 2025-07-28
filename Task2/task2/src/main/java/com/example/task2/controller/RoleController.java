package com.example.task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.task2.dto.RoleDto;
import com.example.task2.log.annotation.LogMethodParam;
import com.example.task2.model.Role;
import com.example.task2.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@LogMethodParam
	@GetMapping("/role/{id}")
	public Role getRoleById(@PathVariable Long id) {
		return roleService.getRoleById(id);
	}

	@LogMethodParam
	@GetMapping("/allroles")
	public List<RoleDto> getAllRoles() {
		return roleService.getRoles();
	}

}
