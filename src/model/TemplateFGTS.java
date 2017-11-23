package model;

public abstract class TemplateFGTS extends Tax {

	private double grossSalary = 0.0;
	private int monthsWorked = 0;
	private double fgtsAccumulated = 0.0;
	private double monthlyDepositedAmount = 0.0;

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public int getMonthsWorked() {
		return monthsWorked;
	}

	public void setMonthsWorked(int monthsWorked) {
		this.monthsWorked = monthsWorked;
	}

	public double getFgtsAccumulated() {
		return fgtsAccumulated;
	}

	public void setFgtsAccumulated(double fgtsAccumulated) {
		this.fgtsAccumulated = fgtsAccumulated;
	}

	public double getMonthlyDepositedAmount() {
		return monthlyDepositedAmount;
	}

	public void setMonthlyDepositedAmount(double monthlyDepositedAmount) {
		this.monthlyDepositedAmount = monthlyDepositedAmount;
	}

	@Override
	public double calcule(Tax tax) {
		
		TemplateFGTS fgts = (TemplateFGTS) tax;
		calculeDepositedAmount(fgts);
		return calculeFgtsAccumulated(fgts);
	}
	
	public abstract double calculeFgtsAccumulated(TemplateFGTS fgts);
	public abstract double calculeDepositedAmount(TemplateFGTS fgts);
}
