package com.gk.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix="emp.info")
public class Employee {
	 //simple properties
		private Integer empNo;
		private  String  empName;
		private  String empAddrs;
		//array type
		private   String[] favColors;
			//Collection List
		private  List<String> nickNames;
		//Collection  Set
		private  Set<Long> phoneNumbers;
		//Collection Map
		private  Map<String,Long> idDetails;
		//HAS -A property
		private   Company   company;
		//setter && getters
		
		
		
		
		
		public void setEmpNo(Integer empNo) {
			this.empNo = empNo;
		}




		public void setEmpName(String empName) {
			this.empName = empName;
		}




		public void setEmpAddrs(String empAddrs) {
			this.empAddrs = empAddrs;
		}




		public void setNickNames(List<String> nickNames) {
			this.nickNames = nickNames;
		}




		public void setPhoneNumbers(Set<Long> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}




		public void setIdDetails(Map<String, Long> idDetails) {
			this.idDetails = idDetails;
		}




		public void setCompany(Company company) {
			this.company = company;
		}
		
		public void setFavColors(String[] favColors) {
			this.favColors = favColors;
		}




		//toString()
		@Override
		public String toString() {
			return "Employee [empNo=" + empNo + ", empName=" + empName + ", empAddrs=" + empAddrs + ", nickNames="
					+ nickNames + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", company=" + company
					+ "]";
		}

}
