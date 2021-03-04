package com.myclass.dto;

public class TaskDto {
	private int id;
	private String name;
	private String startDate;
	private String endDate;
	private int statusId;
	private int userId;
	private int projectId;
	private String statusName;
	private String userName;
	private String projectName; 

	public TaskDto() {
	}
	
	public TaskDto(String name, String startDate2, String endDate2, int statusId, int userId,
			int projectId) {
		this.name = name;
		this.startDate = startDate2;
		this.endDate = endDate2;
		this.statusId = statusId;
		this.userId = userId;
		this.projectId = projectId;
	}

	public TaskDto(int id, String name, String startDate, String endDate, int statusId, int userId,
			int projectId) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statusId = statusId;
		this.userId = userId;
		this.projectId = projectId;
	}
	
	public TaskDto(int id, String name, String startDate, String endDate, int statusId, int userId,
			int projectId, String statusName, String userName, String projectName) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statusId = statusId;
		this.userId = userId;
		this.projectId = projectId;
		this.statusName = statusName;
		this.userName = userName;
		this.projectName = projectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


}
