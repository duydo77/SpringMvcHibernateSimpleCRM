package com.myclass.dto;

public class RoleDto {
	// Properties
	private int id;
	private String name;
	private String description;

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setRole(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Constructors
	public RoleDto() {

	}

	public RoleDto(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public RoleDto(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
