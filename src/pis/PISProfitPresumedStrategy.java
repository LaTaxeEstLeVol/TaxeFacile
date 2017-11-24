package pis;

import abstracts.PIS;

public class PISProfitPresumedStrategy extends PIS {

	@Override
	public double calculePIS(PIS pis) {
		double aliquot = (double) 0.65 / 100;
		pis.setAliquot(aliquot);

		return pis.getMonthlyIncome() * pis.getAliquot();
	}

}
