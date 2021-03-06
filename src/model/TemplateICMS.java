package model;

import controller.ICMS;
import dao.ICMSDao;

public abstract class TemplateICMS extends Tax{

	private double productValue = 0.0;
	private String stateOrigin = "";
	private String stateDestiny = "";
	
	protected ICMSDao icmsDao = new ICMSDao();
	
	public double getProductValue() {
		return productValue;
	}

	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}

	public String getStateOrigin() {
		return stateOrigin;
	}

	public void setStateOrigin(String stateOrigin) {
		this.stateOrigin = stateOrigin;
	}

	public String getStateDestiny() {
		return stateDestiny;
	}

	public void setStateDestiny(String stateDestiny) {
		this.stateDestiny = stateDestiny;
	}

	@Override
	public double calcule(Tax tax) {
		TemplateICMS icms = (TemplateICMS) tax;
		
		if(icmsDao.getAliquotOrigin((ICMS) icms) == true) {
			
			return calculeOrigin(icms);
		} else {
			
			return calculeDestiny(icms);
		}
	}
	
	public abstract double calculeOrigin(TemplateICMS icms);
	public abstract double calculeDestiny(TemplateICMS icms);
}
