package com.gk.sbeans;

import lombok.Setter;

@Setter
public class Company {
	private String name;
	private  Integer size;
	private String addrs;
	private Long pinCode;
	
	//alt+shift+s,r
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	
	
	//toString  (alt+shift+s,s)
	@Override
	public String toString() {
		return "Company [name=" + name + ", size=" + size + ", addrs=" + addrs + ", pinCode=" + pinCode + "]";
	}
}
