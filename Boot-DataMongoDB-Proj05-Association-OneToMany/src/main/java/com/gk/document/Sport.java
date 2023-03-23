package com.gk.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Sport {

	@Id
	private Integer sid;
	private String type;
	private String[] kititems;
	
	// toString()
	
	@Override
	public String toString() {
		return "Sport [sid=" + sid + ", type=" + type + ", kititems=" + Arrays.toString(kititems) + "]";
	}
	
	
}
