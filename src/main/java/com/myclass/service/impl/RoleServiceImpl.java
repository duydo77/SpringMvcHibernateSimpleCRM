package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
@Scope("prototype")
public class RoleServiceImpl implements RoleService {

	RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {

		this.roleRepository = roleRepository;

	}

	@Override
	public List<RoleDto> findAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		try {
			List<Role> entities = roleRepository.findAll();

			for (Role entity : entities) {
				RoleDto dto = new RoleDto(entity.getId(), entity.getName(), entity.getDescription());
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public RoleDto findById(int id) {
		try {
			Role entity = roleRepository.findById(id);
			if (entity != null)
				return new RoleDto(entity.getId(), entity.getName(), entity.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RoleDto();
	}

	@Override
	public int add(RoleDto dto) {
		try {
			Role entity = new Role(dto.getName(), dto.getDescription());	
			roleRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int edit(RoleDto dto) {
		try {
			Role entity = roleRepository.findById(dto.getId());
			if (entity == null)
				return -1;
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			roleRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		try {
			roleRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
