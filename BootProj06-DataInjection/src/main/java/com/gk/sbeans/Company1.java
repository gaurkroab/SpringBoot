package com.gk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("comp1")
public class Company1 {
	@Value("${org.info.name}")
	private String cname;
	@Value("${org.info.location}")
	private String clocation;
	// @Value("${org.info.size}")
	@Value("${hcl.size}")
	private Integer size;
	@Value("${org.info.type1}")
	private String companyType;
	@Value("${org.info.contact}")
	private Long mobileNo;

	// toString()
	public String toString() {
		return "Company1 [cname=" + cname + ", clocation=" + clocation + ", size=" + size + ", companyType="
				+ companyType + ", mobileNo=" + mobileNo + "]";
	}

}
