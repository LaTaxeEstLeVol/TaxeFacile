package abstracts;

import interfaces.Calculable;

public abstract class Tax implements Calculable {

	private double aliquot = 0;
	private String state = "";
	private double valueProduct = 0;

	public double getAliquot() {
		return aliquot;
	}

	public void setAliquot(double aliquot) {
		this.aliquot = aliquot;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getValueProduct() {
		return valueProduct;
	}

	public void setValueProduct(double valueProduct) {
		this.valueProduct = valueProduct;
	}
}