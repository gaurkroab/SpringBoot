package com.gk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp2")
@ConfigurationProperties(prefix = "org.info")
//@Data
@Setter
@ToString
@PropertySource("com/gk/commons/Info.properties")

public class Company2 {
	private String name;
	private String location;

	@Value("${hcl.size}")
	private Integer size1;
	private String type;
	private Long contact;

	// setters (place it only when lombok is not working)
	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setSize1(Integer size1) {
		this.size1 = size1;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	// toString() ( (place it only when lombok is not working))
	@Override
	public String toString() {
		return "Company2 [name=" + name + ", location=" + location + ", size=" + size1 + ", type=" + type + ", contact="
				+ contact + "]";
	}

}
