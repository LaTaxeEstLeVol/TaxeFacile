package controller;

import model.IRPJ;

public class IRPJProfitRealStrategy extends IRPJ {
	
	@Override
	public double calculeIRPJ(IRPJ irpj) {
		
		double aliquot = 15.0/100.0;
		double additionalTax = 10.0/100.0;
		irpj.setAliquot(aliquot);
		
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
		// The value of 60 thousand represents the value of 20 thousand times the period of 1
		// quarter, defined in law
		if (irpj.getFistTrimester() >= 60000.0){
			return irpj.getFirstTrimester() * irpj.getAliquot() * additionalTax ;
		}else{
			return irpj.getFirstTrimester() * irpj.getAliquot();
		}
	}

	@Override
	public double calculeSecondTrimester(IRPJ irpj) {

		// The value of 60 thousand represents the value of 20 thousand times the period of 1
		// quarter, defined in law
		if (irpj.irpj.getSecondTrimester() >= 60000.0){
			return irpj.getSecondTrimester() * irpj.getAliquot() * additionalTax ;
		}else{
			return irpj.getSecondTrimester() * irpj.getAliquot();
		}
	}

	@Override
	public double calculeThirdTrimester(IRPJ irpj) {

		// The value of 60 thousand represents the value of 20 thousand times the period of 1
		// quarter, defined in law
		if (irpj.irpj.getThirdTrimester() >= 60000.0){
			return irpj.getThirdTrimester() * irpj.getAliquot() * additionalTax ;
		}else{
			return irpj.getThirdTrimester() * irpj.getAliquot();
		}
	}

	@Override
	public double calculeFourthTrimester(IRPJ irpj) {

		// The value of 60 thousand represents the value of 20 thousand times the period of 1
		// quarter, defined in law
		if (irpj.irpj.getFourthTrimester() >= 60000.0){
			return irpj.getFourthrimester() * irpj.getAliquot() * additionalTax ;
		}else{
			return irpj.getFourthTrimester() * irpj.getAliquot();
		}
	}
}
