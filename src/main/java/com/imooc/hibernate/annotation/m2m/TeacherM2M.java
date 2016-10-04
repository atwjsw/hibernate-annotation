package com.imooc.hibernate.annotation.m2m;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/*
 * 多对多单向外键关联 Students 《-》 Teachers
 * 
 */
@Entity(name="teacher")
public class TeacherM2M {
	
	@Id
	@GeneratedValue(generator="tid")
	@GenericGenerator(name="tid", strategy="assigned")
	@Column(length=4)
	private String tid;
	private String tname;
	
	//以下部分是
	@ManyToMany(mappedBy="teachers") //主控方交给对方Student,teachers是Student中的集合属性名
	private Set<StudentM2M> students = new HashSet<StudentM2M>();
	
	public TeacherM2M() {
		super();
	}	
	
	public TeacherM2M(String tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Set<StudentM2M> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentM2M> students) {
		this.students = students;
	}

	
	
	
}
