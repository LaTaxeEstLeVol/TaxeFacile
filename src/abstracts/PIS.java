package abstracts;

import pis.PISProfitPresumedStrategy;
import pis.PISProfitRealStrategy;

public abstract class PIS extends Tax {

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

		PIS pis = (PIS) tax;

		if (typeRegimentPIS(pis)) {
			return new PISProfitRealStrategy().calculePIS(pis);
		} else {
			return new PISProfitPresumedStrategy().calculePIS(pis);
		}

	}

	private boolean typeRegimentPIS(PIS pis) {

		if (pis.typeRegiment.equals("Lucro Real")) {
			return true;
		} else {
			return false;
		}
	}

	public abstract double calculePIS(PIS pis);

}
