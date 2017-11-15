package federalTax;

import abstracts.COFINS;

public class COFINSProfitPresumedStrategy extends COFINS {

	@Override
	public double calculeCOFINS(COFINS cofins) {
		
		double aliquot = (double) 3.0/100;
		cofins.setAliquot(aliquot);
		
		return cofins.getMonthlyIncome() * cofins.getAliquot();
	}
}
