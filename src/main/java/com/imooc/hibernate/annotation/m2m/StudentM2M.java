package com.imooc.hibernate.annotation.m2m;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.imooc.hibernate.annotation.o2m.StudentO2M;

/*
 * 多对多单向外键关联 Student-》 Teacher
 */
@Entity(name="student")
public class StudentM2M {
	
	@Id
	@GeneratedValue //自增主键
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	
	@ManyToMany
	@JoinTable(name="teacher_student", 
			joinColumns={@JoinColumn(name="sid")},
			inverseJoinColumns={@JoinColumn(name="tid")})
	private Set<TeacherM2M> teachers = new HashSet<TeacherM2M>();	
	
	public StudentM2M() {
		super();
	}

	public StudentM2M(String sname, String gender, Date birthday, String major) {
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
	
	
	public Set<TeacherM2M> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<TeacherM2M> teachers) {
		this.teachers = teachers;
	}	
}
