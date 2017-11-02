package cityTax;

import abstracts.IPTU;

public class IPTUNotHabitleStrategy extends IPTU{

	@Override
	public double calculeVenalPrice(IPTU iptu) {
		return iptu.getSquareMeterImmobile() * iptu.getSquareMeterRegionPrice();
	}

	@Override
	public double calculeIPTU(IPTU iptu) {
		return calculeVenalPrice(iptu) * iptu.getAliquot();
	}

}
