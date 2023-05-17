package com.appt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.appt.enums.ThemeEnum;

@Entity
public class InvestmentTheme {
	
	@Id
	private String themeName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AssetClass assetClass;
	
	private String risk;
	private String investmentHorizon;


	public void setInvestmentHorizon(String investmentHorizon) {
		this.investmentHorizon = investmentHorizon;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public AssetClass getAssetClass() {
		return assetClass;
	}
	public void setAssetClass(AssetClass assetClass) {
		this.assetClass = assetClass;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	
	
	public InvestmentTheme() {
		super();
	}
	
	public InvestmentTheme(String themeName, AssetClass assetClass, String risk, String investmentHorizon,
			ThemeEnum themeEnum) {
		super();
		this.themeName = themeName;
		this.assetClass = assetClass;
		this.risk = risk;
		this.investmentHorizon = investmentHorizon;

	}
	@Override
	public String toString() {
		return "InvestmentTheme [themeName=" + themeName + ", assetClass=" + assetClass + ", risk=" + risk
				+ ", investmentHorizon=" + investmentHorizon + "]";
	}
	
	
}
