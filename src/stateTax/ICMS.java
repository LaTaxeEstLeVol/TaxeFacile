package stateTax;

public class ICMS extends TemplateICMS {

	@Override
	double stateOrigin(TemplateICMS icms) {
		
		return icms.getAliquotInterState() * icms.getValueProduct();
	}

	@Override
	double stateDestiny(TemplateICMS icms) {
		double stateOrigin = stateOrigin(icms);
		return (icms.getAliquotInternal() * icms.getValueProduct()) - stateOrigin;
	}

	@Override
	double calculeICMS(TemplateICMS icms) {
		double icmsFinal = stateOrigin(icms) + stateDestiny(icms);
		return icmsFinal;
	}
}
