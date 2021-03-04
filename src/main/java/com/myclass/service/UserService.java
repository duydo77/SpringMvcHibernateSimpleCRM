package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;

public interface UserService {
	
	List<UserDto> findAll();

	UserDto findById(int id);

	int add(UserDto dto);

	int edit(UserDto dto);

	int delete(int id);

	List<UserDto> findAllJoin();
	
	List<UserDto> findAllLeader();
}
