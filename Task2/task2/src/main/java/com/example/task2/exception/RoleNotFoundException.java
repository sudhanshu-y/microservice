package com.example.task2.exception;

public class RoleNotFoundException extends RuntimeException {

	public RoleNotFoundException(Long id) {
		super("Role with ID " + id + " not found");
	}
}
