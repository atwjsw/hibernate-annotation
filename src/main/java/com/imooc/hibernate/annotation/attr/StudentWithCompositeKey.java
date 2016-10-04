package com.imooc.hibernate.annotation.attr;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.imooc.hibernate.annotation.clazz.Address;

/*
 * 学生持久化类，使用组合主键
 */
@Entity
@Table(name="student_compk", schema="annotation") 
public class StudentWithCompositeKey {
	
	@EmbeddedId	 //1. 嵌入式组合ID
	private StudentPK pk;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	
	@Transient //表示ORM将忽略此属性，不会生成对应的表字段
	private double salary;
		
	@Embedded //嵌入类
	private Address address;
	
	public StudentWithCompositeKey(StudentPK pk, String sname, String gender, Date birthday, String major,
			Address address) {
		this.pk = pk;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}

	public StudentPK getPk() {
		return pk;
	}

	public void setPk(StudentPK pk) {
		this.pk = pk;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}	
}
