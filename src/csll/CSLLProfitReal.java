package csll;

import abstracts.CSLL;

public class CSLLProfitReal extends CSLL {
	
	public double calcule(CSLL csll) {
		
		double aliquot = 9.0/100.0;
		double result = 0;
		
		csll.setAliquot(aliquot);
		result = (csll.getFirstTrimester() + csll.getSecondTrimester() + csll.getThirdTrimester()) * csll.getAliquot();
		return result;
	}
}
