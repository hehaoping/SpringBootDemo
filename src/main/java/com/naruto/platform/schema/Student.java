package com.naruto.platform.schema;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long ID;

	@Column
	private String Name;

	@Column
	private Integer Age;

	@Column
	private String Sex;

	@Column
	private String ClassName;

	@Column
	private String Memo;

	@Column
	private String Prop1;

	@Column
	private String Prop2;

	@Column
	private String Prop3;

	@Column
	private String Prop4;

	@Column
	private String AddUser;

	@Column
	private Date AddTime;

	@Column
	private String ModifyUser;

	@Column
	private Date ModifyTime;

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

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public String getProp1() {
		return Prop1;
	}

	public void setProp1(String prop1) {
		Prop1 = prop1;
	}

	public String getProp2() {
		return Prop2;
	}

	public void setProp2(String prop2) {
		Prop2 = prop2;
	}

	public String getProp3() {
		return Prop3;
	}

	public void setProp3(String prop3) {
		Prop3 = prop3;
	}

	public String getProp4() {
		return Prop4;
	}

	public void setProp4(String prop4) {
		Prop4 = prop4;
	}

	public String getAddUser() {
		return AddUser;
	}

	public void setAddUser(String addUser) {
		AddUser = addUser;
	}

	public Date getAddTime() {
		return AddTime;
	}

	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}

	public String getModifyUser() {
		return ModifyUser;
	}

	public void setModifyUser(String modifyUser) {
		ModifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return ModifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		ModifyTime = modifyTime;
	}

}