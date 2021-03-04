package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {
	
	List<RoleDto> findAll();

	RoleDto findById(int id);

	int add(RoleDto dto);

	int edit(RoleDto dto);

	int delete(int id);

}
