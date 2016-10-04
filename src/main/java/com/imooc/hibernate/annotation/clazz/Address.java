package com.imooc.hibernate.annotation.clazz;

import javax.persistence.Embeddable;

@Embeddable //非实体类，不会映射为一张表，可以嵌入实体类作为属性存在
public class Address {
	
	private String postCode;
	private String phone;
	private String address;
	
	public Address() {
	}
	
	public Address(String postCode, String phone, String address) {
		this.postCode = postCode;
		this.phone = phone;
		this.address = address;
	}
	
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
