package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "PROJECT" )
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "START_DATE")
	private String startDate;
	
	@Column(name = "END_DATE")
	private String endDate;

	@Column(name = "LEADER_ID")
	private int leaderId;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@ManyToOne
	@JoinColumn(name= "LEADER_ID", insertable = false, updatable = false)
	private User userLeader;
	
	public Project() {
	}

	public Project(int id, String name, String startDate, String endDate, int leaderId) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaderId = leaderId;
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

	public void setLeaderId(int leaderID) {
		this.leaderId = leaderID;
	}

}
