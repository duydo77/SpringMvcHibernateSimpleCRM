package com.myclass.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.ProjectDto;
import com.myclass.service.ProjectService;
import com.myclass.service.UserService;

@Controller
@Scope("prototype")
@RequestMapping("project")
public class ProjectController {

	ProjectService projectService;
	UserService userService;

	public ProjectController(ProjectService projectService, UserService userService) {
		this.projectService = projectService;
		this.userService = userService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<ProjectDto> dtos = projectService.findAllJoin();
		model.addAttribute("dtos", dtos);
		return "project/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("leaderList", userService.findAllLeader());
		return "project/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("leaderId") int leaderId, ModelMap model) {
		ProjectDto dto = new ProjectDto(name, startDate, endDate, leaderId);
		projectService.add(dto);
		return "redirect:/project";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		ProjectDto dto = projectService.findById(id);
		System.out.println(dto.getName());
		model.addAttribute("leaderList", userService.findAllLeader());
		model.addAttribute("dto", dto);
		return "project/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("leaderId") int leaderId) {
		ProjectDto dto = new ProjectDto(id, name, startDate, endDate, leaderId);
		projectService.edit(dto);
		return "redirect:/project";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {
		projectService.delete(id);
		return "redirect:/project";
	}

}
