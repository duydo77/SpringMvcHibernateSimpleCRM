package com.myclass.dto;

public class ProjectDto {

	private int id;
	private String name;
	private String startDate;
	private String endDate;
	private int leaderId;
	private String leaderName;
	
	public ProjectDto() {
	}

	public ProjectDto(int id, String name, String startDate, String endDate, int leaderId) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaderId = leaderId;
	}

	public ProjectDto(String name, String startDate, String endDate, int leaderId) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaderId = leaderId;
	}
	
	public ProjectDto(String name, String startDate, String endDate, int leaderId, String leaderName) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaderId = leaderId;
		this.leaderName = leaderName;
	}
	
	public ProjectDto(int id, String name, String startDate, String endDate, int leaderId, String leaderName) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaderId = leaderId;
		this.leaderName = leaderName;
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

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

}
