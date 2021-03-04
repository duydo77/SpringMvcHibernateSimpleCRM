package com.myclass.repository;

import java.util.List;

import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;

public interface TaskRepository extends BaseRepository<Task, Integer> {
	
	List<TaskDto> findAllJoin();

}
