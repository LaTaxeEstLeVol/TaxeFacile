package icms;

import abstracts.TemplateICMS;

public class ICMS extends TemplateICMS {

	@Override
	public double calculeOrigin(TemplateICMS icms) {

		double value = 0.0;

		value = icms.getProductValue() * icms.getAliquot();

		return value;
	}

	@Override
	public double calculeDestiny(TemplateICMS icms) {

		double value = 0.0;

		if (icmsDao.getAliquotDestiny((ICMS) icms) == true) {

			value = icms.getProductValue() * icms.getAliquot();
		}
		return value;
	}
}