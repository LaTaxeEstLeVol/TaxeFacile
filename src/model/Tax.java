package model;

public abstract class Tax {

	private double aliquot = 0.0;
	private double additionalTax = 0.0;

	public double getAliquot() {
		return aliquot;
	}

	public void setAliquot(double aliquot) {
		this.aliquot = aliquot;
	}
	
	public abstract double calcule(Tax tax);
}