package com.appt.dto;

public class PortfolioDto {
	private String portfolioName;
	private String benchMark;
	private String exchange;
	private double currentValue;
	private double returns;
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public String getBenchMark() {
		return benchMark;
	}
	public void setBenchMark(String benchMark) {
		this.benchMark = benchMark;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public double getReturns() {
		return returns;
	}
	public void setReturns(double returns) {
		this.returns = returns;
	}
	public PortfolioDto() {
		super();
	}
	public PortfolioDto(String portfolioName, String benchMark, String exchange, double currentValue, double returns) {
		super();
		this.portfolioName = portfolioName;
		this.benchMark = benchMark;
		this.exchange = exchange;
		this.currentValue = currentValue;
		this.returns = returns;
	}
	@Override
	public String toString() {
		return "PortfolioDto [portfolioName=" + portfolioName + ", benchMark=" + benchMark + ", exchange=" + exchange
				+ ", currentValue=" + currentValue + ", returns=" + returns + "]";
	}
}
