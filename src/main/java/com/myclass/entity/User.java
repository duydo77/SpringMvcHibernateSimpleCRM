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
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "FULLNAME")
	private String fullname;
	
	@Column(name = "AVATAR")
	private String avatar;
	
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@OneToMany(mappedBy = "userLeader", fetch = FetchType.LAZY)
	private List<Project> projects;
	
	@ManyToOne
	@JoinColumn(name= "ROLE_ID", insertable = false, updatable = false)
	private Role role;
	
	public User() {
	
	}

	public User(int id, String email, String password, String fullname, String avatar, int roleId) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.avatar = avatar;
		this.roleId = roleId;	
	}
	
	public User(String email, String password, String fullname, String avatar, int roleId) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.avatar = avatar;
		this.roleId = roleId;	
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
