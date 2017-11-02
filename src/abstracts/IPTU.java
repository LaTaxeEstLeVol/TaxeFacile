package abstracts;

import cityTax.IPTUHabitleStrategy;

public abstract class IPTU extends Tax {

	private boolean habitable;
	private double squareMeterImmobile;
	private double squareMeterRegionPrice;

	@Override
	public double calcule() {
		return 0;
	}

	public double calcule(IPTU iptu) {
		if (isHabitable(iptu)) {
			return new IPTUHabitleStrategy().calculeIPTU(iptu);
		} else {
			return new IPTUHabitleStrategy().calculeIPTU(iptu);
		}
	}

	private boolean isHabitable(IPTU iptu) {
		if (iptu.habitable)
			return true;
		else
			return false;
	}

	abstract public double calculeVenalPrice(IPTU iptu);

	abstract public double calculeIPTU(IPTU iptu);

	public boolean isHabitable() {
		return habitable;
	}

	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}

	public double getSquareMeterImmobile() {
		return squareMeterImmobile;
	}

	public void setSquareMeterImmobile(double squareMeterImmobile) {
		this.squareMeterImmobile = squareMeterImmobile;
	}

	public double getSquareMeterRegionPrice() {
		return squareMeterRegionPrice;
	}

	public void setSquareMeterRegionPrice(double squareMeterRegionPrice) {
		this.squareMeterRegionPrice = squareMeterRegionPrice;
	}

}
