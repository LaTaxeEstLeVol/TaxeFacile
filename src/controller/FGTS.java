package controller;

import model.TemplateFGTS;

public class FGTS extends TemplateFGTS {

	@Override
	public double calculeDepositedAmount(TemplateFGTS fgts) {
		
		double aliquot = 8.0/100.0;
		fgts.setAliquot(aliquot);
		return fgts.getGrossSalary() * fgts.getAliquot();
	}
	
	@Override
	public double calculeFgtsAccumulated(TemplateFGTS fgts) {
		
		return calculeDepositedAmount(fgts) * fgts.getMonthsWorked();
	}
}
