package federalTax;

import abstracts.COFINS;
import abstracts.Tax;
import concrete.Income;

public class AccumulatedCofinsStrategy extends COFINS {

	public double calcule(Income income) {
		return income.getMonthlyIncome() * 0.03;

	}

	@Override
	public double calcule(Tax tax) {
		// TODO Auto-generated method stub
		return 0;
	}

}
