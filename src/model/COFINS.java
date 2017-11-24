package model;

import controller.COFINSProfitPresumedStrategy;
import controller.COFINSProfitRealStrategy;

public abstract class COFINS extends Tax {

	private double monthlyIncome = 0.0;
	private double accreditedPurchase = 0.0;
	private String typeRegiment = "";

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public double getAccreditedPurchase() {
		return accreditedPurchase;
	}

	public void setAccreditedPurchase(double accreditedPurchase) {
		this.accreditedPurchase = accreditedPurchase;
	}

	public String getTypeRegiment() {
		return typeRegiment;
	}

	public void setTypeRegiment(String typeRegiment) {
		this.typeRegiment = typeRegiment;
	}

	@Override
	public double calcule(Tax tax) {

		COFINS cofins = (COFINS) tax;

		if (typeRegimentCOFINS(cofins) == true) {
			return new COFINSProfitRealStrategy().calculeCOFINS(cofins);
		} else {
			return new COFINSProfitPresumedStrategy().calculeCOFINS(cofins);
		}
	}

	private boolean typeRegimentCOFINS(COFINS cofins) {

		if (cofins.typeRegiment.equals("Lucro Real")) {
			return true;
		} else {
			return false;
		}
	}

	public abstract double calculeCOFINS(COFINS cofins);
}