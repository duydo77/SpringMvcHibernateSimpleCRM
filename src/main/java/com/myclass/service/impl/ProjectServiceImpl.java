package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.ProjectDto;
import com.myclass.dto.UserDto;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;
import com.myclass.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {

		this.projectRepository = projectRepository;

	}

	@Override
	public List<ProjectDto> findAll() {
		List<ProjectDto> dtos = new ArrayList<ProjectDto>();
		try {
			List<Project> entities = projectRepository.findAll();

			for (Project entity : entities) {
				ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getStartDate(),
						entity.getEndDate(), entity.getLeaderId());
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public List<ProjectDto> findAllJoin() {
		List<ProjectDto> dtos = new ArrayList<ProjectDto>();
		try {
			dtos = projectRepository.findAllJoin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public ProjectDto findById(int id) {
		try {
			Project entity = projectRepository.findById(id);
			if (entity != null)
				return new ProjectDto(entity.getId(), entity.getName(), entity.getStartDate(), entity.getEndDate(),
						entity.getLeaderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProjectDto();
	}

	@Override
	public int add(ProjectDto dto) {
		try {
			Project entity = new Project(dto.getId(), dto.getName(), dto.getStartDate(), dto.getEndDate(),
					dto.getLeaderId());
			projectRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int edit(ProjectDto dto) {
		try {
			Project entity = projectRepository.findById(dto.getId());
			if (entity == null)
				return -1;
			entity.setName(dto.getName());
			entity.setStartDate(dto.getStartDate());
			entity.setEndDate(dto.getEndDate());
			entity.setLeaderId(dto.getLeaderId());
			projectRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		try {
			projectRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
