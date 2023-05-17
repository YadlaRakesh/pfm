package com.appt.dto;

public class NseResponseDto {
	
	private String symbol;
	private String securityName;
	private String IsinNo;
	private String sector;
	private String industry;
	private String country;
	private String close;
	private String last;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getIsinNo() {
		return IsinNo;
	}
	public void setIsinNo(String isinNo) {
		IsinNo = isinNo;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public NseResponseDto() {
		super();
	}
	public NseResponseDto(String symbol, String securityName, String isinNo, String sector, String industry,
			String country, String close, String last) {
		super();
		this.symbol = symbol;
		this.securityName = securityName;
		IsinNo = isinNo;
		this.sector = sector;
		this.industry = industry;
		this.country = country;
		this.close = close;
		this.last = last;
	}
	@Override
	public String toString() {
		return "NseResponseDto [symbol=" + symbol + ", securityName=" + securityName + ", IsinNo=" + IsinNo
				+ ", sector=" + sector + ", industry=" + industry + ", country=" + country + ", close=" + close
				+ ", last=" + last + "]";
	}
}
