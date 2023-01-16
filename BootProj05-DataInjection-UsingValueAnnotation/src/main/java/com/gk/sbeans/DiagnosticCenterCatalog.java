package com.gk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dcc")
@Data
public class DiagnosticCenterCatalog {
    @Value("${dc.xrayRate}")
	private Double xrayPrice;
    @Value("${dc.ctscanRate}")
	private  Double  ctscanPrice;
    @Value("${dc.mriScanRate}")
	private   Double MRIScanPrice;
    @Value("${dc.ecgRate}")
	private   Double ecgPrice;
	
    //setters && getters   (getters are required for SPEL operations)
	public double getXrayPrice() {
		return xrayPrice;
	}
	public void setXrayPrice(double xrayPrice) {
		this.xrayPrice = xrayPrice;
	}
	public double getCtscanPrice() {
		return ctscanPrice;
	}
	public void setCtscanPrice(double ctscanPrice) {
		this.ctscanPrice = ctscanPrice;
	}
	public double getMRIScanPrice() {
		return MRIScanPrice;
	}
	public void setMRIScanPrice(double mRIScanPrice) {
		MRIScanPrice = mRIScanPrice;
	}
	public double getEcgPrice() {
		return ecgPrice;
	}
	public void setEcgPrice(double ecgPrice) {
		this.ecgPrice = ecgPrice;
	}


}
