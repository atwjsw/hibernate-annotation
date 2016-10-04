package com.imooc.hibernate.annotation.clazz;

import java.util.Date;

import javax.persistence.Entity; //JPA注解
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 学生持久化类
 */
//@Entity(name="t_student") 可以指定表名
@Entity
@Table(name="student", schema="annotation") //可以同时指定schema名称
public class Student {
	
	
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	// private String address;
	private Address address;
	
	
	public Student() {
		
	}
	
	@Id
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	
}
