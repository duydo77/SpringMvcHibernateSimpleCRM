package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {

		this.userRepository = userRepository;
		this.roleRepository = roleRepository;

	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		try {
			List<User> entities = userRepository.findAll();

			for (User entity : entities) {
				UserDto dto = new UserDto(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getFullname(),
						entity.getAvatar(), entity.getRoleId());
				Role role = roleRepository.findById(entity.getRoleId());
				if (role != null) {
					dto.setRoleName(role.getName());
					dto.setRoleDescription(role.getDescription());
				}
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public List<UserDto> findAllJoin() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		try {
			dtos = userRepository.findAllJoin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public UserDto findById(int id) {
		try {
			User entity = userRepository.findById(id);
			if (entity != null)
				return new UserDto(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getFullname(),
						entity.getAvatar(), entity.getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UserDto();
	}

	@Override
	public int add(UserDto dto) {
		try {
			String pass = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
			User entity = new User(dto.getEmail(), pass, dto.getFullname(), dto.getAvatar(), dto.getRoleId());
			userRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int edit(UserDto dto) {
		try {
			User entity = userRepository.findById(dto.getId());

			if (entity == null)
				return -1;

			if (!dto.getPassword().isEmpty()) {
				entity.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
			}

			entity.setEmail(dto.getEmail());
			entity.setFullname(dto.getFullname());
			entity.setAvatar(dto.getAvatar());
			entity.setRoleId(dto.getRoleId());
			userRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		try {
			userRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<UserDto> findAllLeader() {
		List<UserDto> dtos = new ArrayList<UserDto>();

		try {
			List<User> entities = userRepository.findAllLeader();
			if (entities == null)
				return dtos;
			for (User entity : entities) {
				UserDto dto = new UserDto(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getFullname(),
						entity.getAvatar(), entity.getRoleId());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;
	}

}
