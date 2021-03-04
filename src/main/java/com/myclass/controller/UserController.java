package com.myclass.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.RoleDto;
import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

@Controller
@Scope("prototype")
@RequestMapping("user")
public class UserController {

	UserService userService;
	RoleService roleService;

	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<UserDto> dtos = userService.findAllJoin();
		model.addAttribute("dtos", dtos);
		return "user/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		List<RoleDto> roleDtos = roleService.findAll();
		model.addAttribute("roleDtos", roleDtos);
		return "user/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("fullname") String fullname, @RequestParam("avatar") String avatar,
			@RequestParam("roleId") int roleId, ModelMap model) {
		UserDto dto = new UserDto(email, password, fullname, avatar, roleId);
		userService.add(dto);
		return "redirect:/user";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		UserDto dto = userService.findById(id);
		List<RoleDto> roleDtos = roleService.findAll();
		model.addAttribute("dto", dto);
		model.addAttribute("roleDtos", roleDtos);
		return "user/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("fullname") String fullname, @RequestParam("avatar") String avatar,
			@RequestParam("roleId") int roleId) {
		UserDto dto = new UserDto(id, email, password, fullname, avatar, roleId);
		userService.edit(dto);
		return "redirect:/user";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) {
		userService.delete(id);
		return "redirect:/user";
	}
}
