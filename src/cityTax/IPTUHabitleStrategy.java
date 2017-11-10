package cityTax;

import abstracts.IPTU;
import abstracts.Tax;

public class IPTUHabitleStrategy extends IPTU {

	@Override
	public double calculeVenalPrice(IPTU iptu) {
		
		return iptu.getSquareMeterImmobile() * iptu.getSquareMeterRegionPrice();
	}

	@Override
	public double calculeIPTU(IPTU iptu, Tax tax) {
		
		return calculeVenalPrice(iptu) * tax.getAliquot();
	}

}
