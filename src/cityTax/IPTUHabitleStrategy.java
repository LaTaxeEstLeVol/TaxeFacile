package cityTax;

import abstracts.IPTU;

public class IPTUHabitleStrategy extends IPTU {

	@Override
	public double calculeVenalPrice(IPTU iptu) {
		return iptu.getSquareMeterImmobile() * iptu.getSquareMeterRegionPrice();
	}

	@Override
	public double calculeIPTU(IPTU iptu) {
		return calculeVenalPrice(iptu) * iptu.getAliquot();
	}

}
