package com.appt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	private String isinNo;
	private String symbol;
	private String close;
	private String last;
	private String series;
	public String getIsinNo() {
		return isinNo;
	}
	public void setIsinNo(String isinNo) {
		this.isinNo = isinNo;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Stock() {
		super();
	}
	public Stock(String isinNo, String symbol, String close, String last, String series) {
		super();
		this.isinNo = isinNo;
		this.symbol = symbol;
		this.close = close;
		this.last = last;
		this.series = series;
	}
	@Override
	public String toString() {
		return "Stock [isinNo=" + isinNo + ", symbol=" + symbol + ", close=" + close + ", last=" + last + ", series="
				+ series + "]";
	}
}
