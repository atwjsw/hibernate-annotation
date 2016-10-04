package com.imooc.hibernate.annotation.o2obd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

/*
 * 一对一双向向外键关联 StudentO2O -》 IDCard
 * 1. 需添加Student属性
 * 2. 在Student属性上添加@OneToOne
 * 
 */
@Entity(name="idcard_bd")
public class IDCardBD {
	
	@Id
	@GeneratedValue(generator="pid") //指定一个generator
	@GenericGenerator(name="pid", strategy="assigned") //hibernate的默认generator，手工设置
	@Column(length=18)
	private String pid;
	private String sname;
	
	@OneToOne(mappedBy="iDCard")
	private StudentO2OBD student;
	
	public IDCardBD() {
		super();
	}

	public IDCardBD(String pid, String sname) {
		super();
		this.pid = pid;
		this.sname = sname;
	}
	
	public IDCardBD(String pid, String sname, StudentO2OBD student) {
		super();
		this.pid = pid;
		this.sname = sname;
		this.student = student;
	}

	public StudentO2OBD getStudent() {
		return student;
	}

	public void setStudent(StudentO2OBD student) {
		this.student = student;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}
