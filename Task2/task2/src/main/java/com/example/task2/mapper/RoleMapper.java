package com.example.task2.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.task2.dto.RoleDto;
import com.example.task2.model.Role;

@Component
public class RoleMapper {

	public RoleDto toDto(Role role) {
		RoleDto roleDto = new RoleDto();
		BeanUtils.copyProperties(role, roleDto);
		return roleDto;
	}

}
