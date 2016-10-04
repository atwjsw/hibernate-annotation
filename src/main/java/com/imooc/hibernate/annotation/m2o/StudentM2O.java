package com.imooc.hibernate.annotation.m2o;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*
 * 多对一单向外键关联 Students -》 ClassRoom
 * Student多方
 */
@Entity(name="student_m2o")
public class StudentM2O {
	
	@Id
	@GeneratedValue //自增主键
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private ClassRoom classRoom;
	
	public StudentM2O() {
		super();
	}
	public StudentM2O(String sname, String gender, Date birthday, String major, ClassRoom classRoom) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.classRoom = classRoom;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
}
