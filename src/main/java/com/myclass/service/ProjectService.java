package com.myclass.service;

import java.util.List;

import com.myclass.dto.ProjectDto;

public interface ProjectService {

	List<ProjectDto> findAll();
	
	ProjectDto findById(int id);

	int add(ProjectDto dto);

	int edit(ProjectDto dto);
	
	int delete(int id);
	
	List<ProjectDto> findAllJoin();

}
