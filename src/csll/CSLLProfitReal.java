package csll;

import abstracts.CSLL;

public class CSLLProfitReal extends CSLL {
	
	public double calcule(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		csll.setAliquot(aliquot);
		
		double result = 0;
		double first = firstTrimester(csll);
		double second = secondTrimester(csll);
		double third = thirdTrimester(csll);
		double fourth = fourthTrimester(csll);
		
		result = first + second + third + fourth;
		return result;
	}

	@Override
	public double firstTrimester(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		csll.setAliquot(aliquot);
		return csll.getFirstTrimester() * csll.getAliquot();
	}

	@Override
	public double secondTrimester(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		csll.setAliquot(aliquot);
		return csll.getSecondTrimester() * csll.getAliquot();
	}

	@Override
	public double thirdTrimester(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		csll.setAliquot(aliquot);
		return csll.getThirdTrimester() * csll.getAliquot();
	}

	@Override
	public double fourthTrimester(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		csll.setAliquot(aliquot);
		return csll.getFourthTrimester() * csll.getAliquot();
	}
}
