package stateTax;

import abstracts.Tax;

public abstract class TemplateICMS extends Tax {

	private double aliquotInternal = 0.0;
	private double aliquotInterState = 0.0;

	public double getAliquotInternal() {
		return aliquotInternal;
	}

	public void setAliquotInternal(double aliquotInternal) {
		this.aliquotInternal = aliquotInternal;
	}

	public double getAliquotInterState() {
		return aliquotInterState;
	}

	public void setAliquotInterState(double aliquotInterState) {
		this.aliquotInterState = aliquotInterState;
	}

	public double calcule(TemplateICMS icms) {
		stateOrigin(icms);
		stateDestiny(icms);
		return calculeICMS(icms);
	}

	abstract double stateOrigin(TemplateICMS icms);

	abstract double stateDestiny(TemplateICMS icms);

	abstract double calculeICMS(TemplateICMS icms);

	@Override
	public double calcule() {

		return 0;
	}
}
