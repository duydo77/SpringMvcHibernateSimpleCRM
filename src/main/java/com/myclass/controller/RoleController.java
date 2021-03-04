package com.myclass.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.RoleDto;
import com.myclass.service.RoleService;

@Controller
@Scope("prototype")
@RequestMapping("role")
public class RoleController {

	RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<RoleDto> dtos = roleService.findAll();
		model.addAttribute("dtos", dtos);
		return "role/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "role/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("description") String description, ModelMap model) {
		RoleDto dto = new RoleDto(name, description);
		roleService.add(dto);
		return "redirect:/role";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		RoleDto dto = roleService.findById(id);
		model.addAttribute("dto", dto);
		return "role/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("description") String description) {
		RoleDto dto = new RoleDto(id, name, description);
		roleService.edit(dto);
		return "redirect:/role";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {
		roleService.delete(id);
		return "redirect:/role";
	}
}
