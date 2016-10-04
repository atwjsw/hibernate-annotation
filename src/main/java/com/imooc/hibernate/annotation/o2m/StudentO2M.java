package com.imooc.hibernate.annotation.o2m;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * 一对多单向外键关联 ClassRomm -》 StudentO2M
 */
@Entity(name="student_o2m")
public class StudentO2M {
	
	@Id
	@GeneratedValue //自增主键
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	
	
	public StudentO2M() {
		super();
	}

	public StudentO2M(String sname, String gender, Date birthday, String major) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
