package com.imooc.hibernate.annotation.attr;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * 组合主键类，1. 组合主键类必须实现hashCode和equals方法
 */
@Embeddable
public class StudentPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//3. 组合主键类必须限定字段长度
	@Column(length=18)
	private String pid; //身份证号
	@Column(length=8)
	private String sid; //学号
	
	public StudentPK() {		
	}

	public StudentPK(String pid, String sid) {
		this.pid = pid;
		this.sid = sid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	//2. 组合主键类必须实现hashCode和equals方法
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	//2. 组合主键类必须实现hashCode和equals方法
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
