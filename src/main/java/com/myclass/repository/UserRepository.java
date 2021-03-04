package com.myclass.repository;

import java.util.List;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;

public interface UserRepository extends BaseRepository<User, Integer>{
	
	List<UserDto> findAllJoin();
	
	List<User> findAllLeader();
}
