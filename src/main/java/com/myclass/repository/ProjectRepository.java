package com.myclass.repository;

import java.util.List;

import com.myclass.dto.ProjectDto;
import com.myclass.entity.Project;

public interface ProjectRepository extends BaseRepository<Project, Integer>{

	List<ProjectDto> findAllJoin();

}
