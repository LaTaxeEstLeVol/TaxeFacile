package model;

import controller.IPI;

public abstract class IPI extends Tax {

	//generalizated values from different IPI types
	private String steelTax = 0.05;
	private double gearTax = 0.115;
	private double inkTax = 0.10;
	private double solventInkTax = 0.25;
	
	public String getSteelTax() {
		return steelTax;
	}
	public void setSteelTax(String steelTax) {
		this.steelTax = steelTax;
	}
	public double getGearTax() {
		return gearTax;
	}
	public void setGearTax(double gearTax) {
		this.gearTax = gearTax;
	}
	public double getInkTax() {
		return inkTax;
	}
	public void setInkTax(double inkTax) {
		this.inkTax = inkTax;
	}
	public double getSolventInkTax() {
		return solventInkTax;
	}
	public void setSolventInkTax(double solventInkTax) {
		this.solventInkTax = solventInkTax;
	}


}
