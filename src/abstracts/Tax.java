package abstracts;

import interfaces.Calculable;

public abstract class Tax implements Calculable {

	private double aliquot;
	private String state;

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
}
