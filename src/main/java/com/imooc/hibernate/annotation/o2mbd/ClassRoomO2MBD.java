package com.imooc.hibernate.annotation.o2mbd;

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

/*
 * 一对多双向外键关联 ClassRoom <-> Student
 * 貌似这1对多，多对一，1对多双向创建的表结构是一直的，
 * 差别在于在Java代码里是否能够从一个对象获取另一对象的数据，
 * 获取数据时Hibernate内部会出来数据的加载
 */
@Entity(name="classroom_o2mbd")
public class ClassRoomO2MBD {
	
	@Id
	@GeneratedValue(generator="cid")
	@GenericGenerator(name="cid", strategy="assigned")
	@Column(length=4)
	private String cid;
	private String cname;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private Set<StudentO2MBD> students = new HashSet<StudentO2MBD>();
		
	public Set<StudentO2MBD> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentO2MBD> students) {
		this.students = students;
	}
	public ClassRoomO2MBD() {
		super();
	}
	
	public ClassRoomO2MBD(String cid, String cname) {
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
