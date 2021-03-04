package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;
import com.myclass.repository.TaskRepository;
import com.myclass.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {

		this.taskRepository = taskRepository;

	}

	@Override
	public List<TaskDto> findAll() {
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		try {
			dtos = taskRepository.findAllJoin();
			
//			List<Task> entities = taskRepository.findAll();
			
//			for (Task entity : entities) {
//				TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getStartDate(), entity.getEndDate(),
//						entity.getStatusId(), entity.getUserId(), entity.getProjectId());
//				Status status = entity.getStatus();
//				Project project = entity.getProject();
//				User user = entity.getUser();
//				dto.setStatusName(status.getName());
//				dto.setProjectName(project.getName());
//				dto.setUserName(user.getFullname());
//				dtos.add(dto);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public TaskDto findById(int id) {
		try {
			Task entity = taskRepository.findById(id);
			if (entity != null)
				return new TaskDto(entity.getId(), entity.getName(), entity.getStartDate(), entity.getEndDate(),
						entity.getStatusId(), entity.getUserId(), entity.getProjectId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TaskDto();
	}

	@Override
	public int add(TaskDto dto) {
		try {
			Task entity = new Task(dto.getId(), dto.getName(), dto.getStartDate(), dto.getEndDate(), dto.getStatusId(),
					dto.getUserId(), dto.getProjectId());
			taskRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int edit(TaskDto dto) {
		try {
			Task entity = taskRepository.findById(dto.getId());
			if (entity == null)
				return -1;
			entity.setName(dto.getName());
			entity.setStartDate(dto.getStartDate());
			entity.setEndDate(dto.getEndDate());
			entity.setProjectId(dto.getProjectId());
			entity.setStatusId(dto.getStatusId());
			entity.setUserId(dto.getUserId());
			taskRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		try {
			taskRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
