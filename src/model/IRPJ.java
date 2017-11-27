package model;

import controller.IRPJProfitRealStrategy;
import controller.IRPJProfitPresumedStrategy;


public abstract class IRPJ extends Tax {

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
		
		IRPJ irpj = (IRPJ) tax;
		
		if (typeRegiment(irpj) == true) {
			return new IRPJProfitRealStrategy().calculeIRPJ(irpj);
		} else {
			return new IRPJProfitPresumedStrategy().calculeIRPJ(irpj);
		}
	}

	private boolean typeRegiment(IRPJ irpj) {
		
		if (irpj.getTypeRegiment().equals("Lucro Real")) {
			return true;
		} else {
			return false;
		}
	}
	
	public abstract double calculeFirstTrimester(IRPJ irpj);
	public abstract double calculeSecondTrimester(IRPJ irpj);
	public abstract double calculeThirdTrimester(IRPJ irpj);
	public abstract double calculeFourthTrimester(IRPJ irpj);
	public abstract double calculeIRPJ(IRPJ irpj);
}
