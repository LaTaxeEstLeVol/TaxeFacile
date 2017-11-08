package abstracts;

import csll.CSLLProfitReal;

public abstract class CSLL extends Tax {

	private String typeRegiment = "";
	private double firstTrimester = 0.0;
	private double secondTrimester = 0.0;
	private double thirdTrimester = 0.0;

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
	public double calcule() {

		return 0;
	}
	
	public double calcule(CSLL csll) {
		if(typeRegiment(csll)) {
			return new CSLLProfitReal().calcule();
		} else {
			return 0;
		}
	}
	
	private boolean typeRegiment(CSLL csll) {
		if(csll.getTypeRegiment().equals("Lucro Real")) {
			return true;
		} else {
			return false;
		}
	}
}
