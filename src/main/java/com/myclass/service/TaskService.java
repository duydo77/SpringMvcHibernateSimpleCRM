package com.myclass.service;

import java.util.List;

import com.myclass.dto.TaskDto;

public interface TaskService {
	
	List<TaskDto> findAll();

	TaskDto findById(int id);

	int add(TaskDto dto);

	int edit(TaskDto dto);

	int delete(int id);
}
