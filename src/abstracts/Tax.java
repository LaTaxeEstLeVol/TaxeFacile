package abstracts;

public abstract class Tax {

	private int id = 0;
	private double aliquot = 0.0;
	private String state = "";

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

	public int getId() {
		return id;
	}

	public void setId(int idTax) {
		this.id = idTax;
	}

	public abstract double calcule(Tax tax);
}
