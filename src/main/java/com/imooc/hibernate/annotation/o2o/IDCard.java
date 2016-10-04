package com.imooc.hibernate.annotation.o2o;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/*
 * 一对一单向外键关联 StudentO2O -》 IDCard
 */
@Entity
public class IDCard {
	
	@Id
	@GeneratedValue(generator="pid") //指定一个generator
	@GenericGenerator(name="pid", strategy="assigned") //hibernate的默认generator，手工设置
	@Column(length=18)
	private String pid;
	private String sname;
	
	public IDCard() {
		super();
	}

	public IDCard(String pid, String sname) {
		super();
		this.pid = pid;
		this.sname = sname;
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
