package com.project.myapp.users.dto;

public class UsersDto {
	private String id;
	private String pwd;
	private String profile;
	private String redgate;
	
	public UsersDto() {}

	public UsersDto(String id, String pwd, String profile, String redgate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.profile = profile;
		this.redgate = redgate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getRedgate() {
		return redgate;
	}

	public void setRedgate(String redgate) {
		this.redgate = redgate;
	}
}
