package abstracts;

import csll.CSLLProfitRealStrategy;
import csll.CSLLProfixPresumedStrategy;

public abstract class CSLL extends Tax {

	private String typeRegiment = "";
	private double firstTrimester = 0.0;
	private double secondTrimester = 0.0;
	private double thirdTrimester = 0.0;
	private double fourthTrimester = 0.0;

	public double getFourthTrimester() {
		return fourthTrimester;
	}

	public void setFourthTrimester(double fourthTrimester) {
		this.fourthTrimester = fourthTrimester;
	}

	public double getFirstTrimester() {
		return firstTrimester;
	}

	public void setFirstTrimester(double firstTrimester) {
		this.firstTrimester = firstTrimester;
	}

	public double getSecondTrimester() {
		return secondTrimester;
	}

	public void setSecondTrimester(double secondTrimester) {
		this.secondTrimester = secondTrimester;
	}

	public double getThirdTrimester() {
		return thirdTrimester;
	}

	public void setThirdTrimester(double thirdTrimester) {
		this.thirdTrimester = thirdTrimester;
	}

	public String getTypeRegiment() {
		return typeRegiment;
	}

	public void setTypeRegiment(String typeRegiment) {
		this.typeRegiment = typeRegiment;
	}

	@Override
	public double calcule(Tax tax) {
		
		CSLL csll = (CSLL) tax;
		
		if (typeRegiment(csll) == true) {
			return new CSLLProfitRealStrategy().calculeCSLL(csll);
		} else {
			return new CSLLProfixPresumedStrategy().calculeCSLL(csll);
		}
	}

	private boolean typeRegiment(CSLL csll) {
		
		if (csll.getTypeRegiment().equals("Lucro Real")) {
			return true;
		} else {
			return false;
		}
	}
	
	public abstract double calculeFirstTrimester(CSLL csll);
	public abstract double calculeSecondTrimester(CSLL csll);
	public abstract double calculeThirdTrimester(CSLL csll);
	public abstract double calculeFourthTrimester(CSLL csll);
	public abstract double calculeCSLL(CSLL csll);
}