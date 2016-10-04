package com.imooc.hibernate.annotation.o2mbd;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * 一对多单向外键关联 ClassRomm -》 StudentO2M
 */
@Entity(name="student_o2mbd")
public class StudentO2MBD {
	
	@Id
	@GeneratedValue //自增主键
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private ClassRoomO2MBD classroom;	
	
	public StudentO2MBD() {
		super();
	}

	public StudentO2MBD(String sname, String gender, Date birthday, String major) {
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

	public ClassRoomO2MBD getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoomO2MBD classroom) {
		this.classroom = classroom;
	}	
}
