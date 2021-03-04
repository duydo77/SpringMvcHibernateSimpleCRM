package com.myclass.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.StatusDto;
import com.myclass.service.StatusService;

@Controller
@Scope("prototype")
@RequestMapping("status")
public class StatusController {

	StatusService statusService;

	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<StatusDto> dtos = statusService.findAll();
		model.addAttribute("dtos", dtos);
		return "status/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "status/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, ModelMap model) {
		StatusDto dto = new StatusDto(name);
		statusService.add(dto);
		return "redirect:/status";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		StatusDto dto = statusService.findById(id);
		model.addAttribute("dto", dto);
		return "status/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name) {
		StatusDto dto = new StatusDto(id, name);
		statusService.edit(dto);
		return "redirect:/status";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {
		statusService.delete(id);
		return "redirect:/status";
	}
}

