package controller;

import model.CSLL;

public class CSLLProfitRealStrategy extends CSLL {
	
	@Override
	public double calculeCSLL(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		csll.setAliquot(aliquot);
		
		double result = 0;
		double first = calculeFirstTrimester(csll);
		double second = calculeSecondTrimester(csll);
		double third = calculeThirdTrimester(csll);
		double fourth = calculeFourthTrimester(csll);
		
		result = first + second + third + fourth;
		return result;
	}

	@Override
	public double calculeFirstTrimester(CSLL csll) {

		return csll.getFirstTrimester() * csll.getAliquot();
	}

	@Override
	public double calculeSecondTrimester(CSLL csll) {

		return csll.getSecondTrimester() * csll.getAliquot();
	}

	@Override
	public double calculeThirdTrimester(CSLL csll) {

		return csll.getThirdTrimester() * csll.getAliquot();
	}

	@Override
	public double calculeFourthTrimester(CSLL csll) {

		return csll.getFourthTrimester() * csll.getAliquot();
	}
}