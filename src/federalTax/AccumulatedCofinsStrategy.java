package federalTax;

import abstracts.COFINS;
import concrete.Income;

public class AccumulatedCofinsStrategy extends COFINS {

	@Override
	public double calcule() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calcule(Income income) {
		return income.getMonthlyIncome() * 0.03;

	}

}
