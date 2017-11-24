package controller;

import model.COFINS;

public class COFINSProfitRealStrategy extends COFINS {

	@Override
	public double calculeCOFINS(COFINS cofins) {
		
		double aliquot = (double) 7.6/100;
		cofins.setAliquot(aliquot);
		
		return partialCofins(cofins) - totalCredit(cofins);
	}
	
	public double partialCofins(COFINS cofins) {
				
		return cofins.getMonthlyIncome() * cofins.getAliquot(); 
	}
	
	public double totalCredit(COFINS cofins) {
		
		return cofins.getAccreditedPurchase() * cofins.getAliquot();
	}
}
