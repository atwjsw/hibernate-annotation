package com.imooc.hibernate.annotation.attr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity; //JPA注解
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.imooc.hibernate.annotation.clazz.Address;
/*
 * 学生持久化类
 */
//@Entity(name="t_student") 可以指定表名
@Entity
@Table(name="student", schema="annotation") //1.可以同时指定schema名称
public class Student implements Serializable{
	
	//@Id
	//@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.AUTO) //3. 同上，GenerationType.AUTO是默认值
	//private int sid;
	
	@Id
	@Column(length=8)
	@GeneratedValue(generator="sid")					//5.用String	作为主键是配置手工设置主键值
	@GenericGenerator(name="sid", strategy="assigned") 
	//@GeneratedValue(strategy=GenerationType.AUTO) //4. 用String做为主键并设自增主键无法生成表。
	private String sid;
	
	
	//@Id
	//@Column(length=20) //2. sname作为联合主键。需要限制长度，否则太长（255）无法作为主键
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	// private String address;
	
	@Embedded //6. 嵌入类
	private Address address;	
	
	public Student() {
		
	}
	
	public Student(String sid, String sname, String gender, Date birthday, String major, Address address) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}

	//@Id (也可以放getter上）
	/*public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}*/
	

	public String getSname() {
		return sname;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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
