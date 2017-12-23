package com.naruto.platform.schema;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long ID;

	private String Name;

	private Integer Age;

	private String Email;

	private String Password;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


}