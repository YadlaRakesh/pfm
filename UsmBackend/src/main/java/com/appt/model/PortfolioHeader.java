package com.appt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PortfolioHeader {
	
	@Id
	private String portfolioName;
	private String fundamanagerName;
	private String portfolioType;
	//private String investmentTheme;
	private String baseCurrency;
	private String rebalancingFrequency;
	
	private String benchMark;
	private String exchange;
	private double investmentValue;
	private double currentValue;
	private double returns;
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public String getFundamanagerName() {
		return fundamanagerName;
	}
	public void setFundamanagerName(String fundamanagerName) {
		fundamanagerName = fundamanagerName;
	}
	public String getPortfolioType() {
		return portfolioType;
	}
	public void setPortfolioType(String portfolioType) {
		this.portfolioType = portfolioType;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getRebalancingFrequency() {
		return rebalancingFrequency;
	}
	public void setRebalancingFrequency(String rebalancingFrequency) {
		this.rebalancingFrequency = rebalancingFrequency;
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
	public double getInvestmentValue() {
		return investmentValue;
	}
	public void setInvestmentValue(double investmentValue) {
		this.investmentValue = investmentValue;
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
	@Override
	public String toString() {
		return "PortfolioHeader [portfolioName=" + portfolioName + ", FundamanagerName=" + fundamanagerName
				+ ", portfolioType=" + portfolioType + ", baseCurrency=" + baseCurrency + ", rebalancingFrequency="
				+ rebalancingFrequency + ", benchMark=" + benchMark + ", exchange=" + exchange + ", investmentValue="
				+ investmentValue + ", currentValue=" + currentValue + ", returns=" + returns + "]";
	}
	
//	public String getPortfolioName() {
//		return portfolioName;
//	}
//	public void setPortfolioName(String portfolioName) {
//		this.portfolioName = portfolioName;
//	}
//	public String getPortfolioType() {
//		return portfolioType;
//	}
//	public void setPortfolioType(String portfolioType) {
//		this.portfolioType = portfolioType;
//	}
////	public String getInvestmentTheme() {
////		return investmentTheme;
////	}
////	public void setInvestmentTheme(String investmentTheme) {
////		this.investmentTheme = investmentTheme;
////	}
//	public String getBaseCurrency() {
//		return baseCurrency;
//	}
//	public void setBaseCurrency(String baseCurrency) {
//		this.baseCurrency = baseCurrency;
//	}
//	public String getRebalancingFrequency() {
//		return rebalancingFrequency;
//	}
//	public void setRebalancingFrequency(String rebalancingFrequency) {
//		this.rebalancingFrequency = rebalancingFrequency;
//	}
//	public String getBenchMark() {
//		return benchMark;
//	}
//	public void setBenchMark(String benchMark) {
//		this.benchMark = benchMark;
//	}
//	public String getExchange() {
//		return exchange;
//	}
//	public void setExchange(String exchange) {
//		this.exchange = exchange;
//	}
//	public double getInvestmentValue() {
//		return investmentValue;
//	}
//	public void setInvestmentValue(double investmentValue) {
//		this.investmentValue = investmentValue;
//	}
//	public double getCurrentValue() {
//		return currentValue;
//	}
//	public void setCurrentValue(double currentValue) {
//		this.currentValue = currentValue;
//	}
//	public double getReturns() {
//		return returns;
//	}
//	public void setReturns(double returns) {
//		this.returns = returns;
//	}
//	public PortfolioHeader() {
//		super();
//	}
//	public PortfolioHeader(String portfolioName, String portfolioType, String investmentTheme, String baseCurrency,
//			String rebalancingFrequency, String benchMark, String exchange, double investmentValue, double currentValue,
//			double returns) {
//		super();
//		this.portfolioName = portfolioName;
//		this.portfolioType = portfolioType;
//		//this.investmentTheme = investmentTheme;
//		this.baseCurrency = baseCurrency;
//		this.rebalancingFrequency = rebalancingFrequency;
//		this.benchMark = benchMark;
//		this.exchange = exchange;
//		this.investmentValue = investmentValue;
//		this.currentValue = currentValue;
//		this.returns = returns;
//	}
//	@Override
//	public String toString() {
//		return "PortfolioHeader [portfolioName=" + portfolioName + ", portfolioType=" + portfolioType
//				+ ", baseCurrency=" + baseCurrency + ", rebalancingFrequency="
//				+ rebalancingFrequency + ", benchMark=" + benchMark + ", exchange=" + exchange + ", investmentValue="
//				+ investmentValue + ", currentValue=" + currentValue + ", returns=" + returns + "]";
//	}

}
