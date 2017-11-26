package controller;

import model.IRPJ;

public class IRPJProfixPresumedStrategy extends IRPJ{

	@Override
	public double calculeCSLL(IRPJ irpj) {
		
		double aliquot = 3.2/100.0;
		csll.setAliquot(aliquot);
		
		double result = 0;
		double first = calculeFirstTrimester(irpj);
		double second = calculeSecondTrimester(irpj);
		double third = calculeThirdTrimester(irpj);
		double fourth = calculeFourthTrimester(irpj);
		
		result = first + second + third + fourth;
		return result;
	}
	
	@Override
	public double calculeFirstTrimester(IRPJ irpj) {

		return irpj.getFirstTrimester() * irpj.getAliquot();
	}

	@Override
	public double calculeSecondTrimester(IRPJ irpj) {
		
		return irpj.getSecondTrimester() * irpj.getAliquot();
	}

	@Override
	public double calculeThirdTrimester(IRPJ irpj) {

		return irpj.getThirdTrimester() * irpj.getAliquot();
	}

	@Override
	public double calculeFourthTrimester(IRPJ irpj) {

		return irpj.getFourthTrimester() * irpj.getAliquot();
	}	
}
