package com.imooc.hibernate.annotation.o2o;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * 一对一单向外键关联 StudentO2O -》 IDCard
 */
@Entity(name="student_o2o")
public class StudentO2O {
	
	@Id
	@GeneratedValue //自增主键
	private int sid;	
	private String gender;
	private Date birthday;
	private String major;
		
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid", unique=true)
	private IDCard iDCard;
	
	public StudentO2O() {
		super();
	}

	public StudentO2O(String gender, Date birthday, String major, IDCard iDCard) {
		super();
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.iDCard = iDCard;
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

	public IDCard getiDCard() {
		return iDCard;
	}

	public void setiDCard(IDCard iDCard) {
		this.iDCard = iDCard;
	}
}
