package com.imooc.hibernate.annotation.o2m;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="classroom_o2m")
public class ClassRoomO2M {
	
	@Id
	@GeneratedValue(generator="cid")
	@GenericGenerator(name="cid", strategy="assigned")
	@Column(length=4)
	private String cid;
	private String cname;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private Set<StudentO2M> students = new HashSet<StudentO2M>();
		
	public Set<StudentO2M> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentO2M> students) {
		this.students = students;
	}
	public ClassRoomO2M() {
		super();
	}
	
	public ClassRoomO2M(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
