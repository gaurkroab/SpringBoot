package com.gk.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Medal {

	@Id
	private Integer mid;
	private String mname;
	private String event;
	private String place;
	
	// toString()
	
	@Override
	public String toString() {
		return "Medal [mid=" + mid + ", mname=" + mname + ", event=" + event + ", place=" + place + "]";
	}
	
	
}
