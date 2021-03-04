package com.myclass.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.TaskDto;
import com.myclass.service.ProjectService;
import com.myclass.service.StatusService;
import com.myclass.service.TaskService;
import com.myclass.service.UserService;

@Controller
@Scope("prototype")
@RequestMapping("task")
public class TaskController {

	TaskService taskService;
	StatusService statusService;
	ProjectService projectService;
	UserService userService;

	public TaskController(TaskService taskService, StatusService statusService, ProjectService projectService,
			UserService userService) {
		this.taskService = taskService;
		this.statusService = statusService;
		this.projectService = projectService;
		this.userService = userService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<TaskDto> dtos = taskService.findAll();
		model.addAttribute("dtos", dtos);
		return "task/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("statusList", statusService.findAll());
		model.addAttribute("projectList", projectService.findAll());
		model.addAttribute("userList", userService.findAll());
		return "task/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("projectId") int projectId,
			@RequestParam("statusId") int statusId, @RequestParam("userId") int userId, ModelMap model) {
		TaskDto dto = new TaskDto(name, startDate, endDate, statusId, userId, projectId);
		taskService.add(dto);
		return "redirect:/task";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		TaskDto dto = taskService.findById(id);
		model.addAttribute("dto", dto);
		model.addAttribute("statusList", statusService.findAll());
		model.addAttribute("projectList", projectService.findAll());
		model.addAttribute("userList", userService.findAll());
		return "task/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("projectId") int projectId, @RequestParam("statusId") int statusId,
			@RequestParam("userId") int userId) {
		TaskDto dto = new TaskDto(id, name, startDate, endDate, statusId, userId, projectId);
		taskService.edit(dto);
		return "redirect:/task";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {
		taskService.delete(id);
		return "redirect:/task";
	}
}
