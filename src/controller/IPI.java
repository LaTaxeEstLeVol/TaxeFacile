package controller;

public class IPI {

	@Override
	public double baseCalcule(Float, productValue, Float ipiPercent,Float truckage, Float insurance) {

		double aliquot = 8.0/100.0;
		double baseCalcule = productValue + (productValue*ipiPercent) + truckage + insurance;
		double ipiValue = baseCalcule * (aliquot/100.0);

		return
	}

}
