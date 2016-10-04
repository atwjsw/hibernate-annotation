package com.imooc.hibernate.annotation.o2obd;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * 一对一双向外键关联 StudentO2O 《-》 IDCard
 * Student类无变化
 */
@Entity(name="student_o2obd")
public class StudentO2OBD {
	
	@Id
	@GeneratedValue //自增主键
	private int sid;	
	private String gender;
	private Date birthday;
	private String major;
		
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid", unique=true)
	private IDCardBD iDCard;
	
	public StudentO2OBD() {
		super();
	}

	public StudentO2OBD(String gender, Date birthday, String major, IDCardBD iDCard) {
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

	public IDCardBD getiDCard() {
		return iDCard;
	}

	public void setiDCard(IDCardBD iDCard) {
		this.iDCard = iDCard;
	}
}
