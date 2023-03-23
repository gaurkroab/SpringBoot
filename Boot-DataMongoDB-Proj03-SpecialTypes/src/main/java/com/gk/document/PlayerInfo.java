package com.gk.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PlayerInfo {

	@Id
	private Integer pid;
	private String pname;
	private String paddrs;
	private List<String> nikNames;
	private Set<Long> contactNumbers;
	private String[] friends;
	private Map<String,String> impKnoks;
	private Properties idDetails;
}
