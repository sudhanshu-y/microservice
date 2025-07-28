package com.example.task2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2.dto.RoleDto;
import com.example.task2.exception.RoleNotFoundException;
import com.example.task2.log.annotation.LogMethodParam;
import com.example.task2.mapper.RoleMapper;
import com.example.task2.model.Role;
import com.example.task2.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleMapper roleMapper;

	@LogMethodParam
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
	}

	@LogMethodParam
	public List<RoleDto> getRoles() {
		List<Role> allRoles = roleRepository.findAll();

		Map<Long, RoleDto> map = new HashMap<>();

		for (Role role : allRoles) {
			map.put(role.getId(), roleMapper.toDto(role));
		}

		List<RoleDto> root = new ArrayList<>();

		// Traverse through each parentId and form structure.
		for (Role role : allRoles) {
			if (role.getParentId() == 0) {
				root.add(map.get(role.getId()));
			} else {
				RoleDto parent = map.get(role.getParentId());
				if (parent != null) {
					parent.getSubClasses().add(map.get(role.getId()));
				}
			}
		}

		return root;
	}

}
