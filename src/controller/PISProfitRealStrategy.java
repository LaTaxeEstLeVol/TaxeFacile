package controller;

import model.PIS;

public class PISProfitRealStrategy extends PIS {

	@Override
	public double calculePIS(PIS pis) {

		double aliquot = (double) 1.65 / 100;
		pis.setAliquot(aliquot);

		return partialPIS(pis) - totalCredit(pis);
	}

	public double partialPIS(PIS pis) {

		return pis.getMonthlyIncome() * pis.getAliquot();
	}

	public double totalCredit(PIS pis) {

		return pis.getAccreditedPurchase() * pis.getAliquot();
	}

}
