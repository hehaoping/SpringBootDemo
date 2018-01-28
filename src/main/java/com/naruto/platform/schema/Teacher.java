package com.naruto.platform.schema;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author hhp
 * @mail 1228929031@qq.com
 * @date 2018年1月27日
 */
@Entity
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@Column
	private long schoolID;
	@Column
	private String name;
	@Column
	private String code;
	@Column
	private String memo;
	@Column
	private String prop1;
	@Column
	private String prop2;
	@Column
	private String adduser;
	@Column
	private Date addtime;
	@Column
	private String modifyuser;
	@Column
	private Date modifytime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	public String getAdduser() {
		return adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getModifyuser() {
		return modifyuser;
	}

	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}
