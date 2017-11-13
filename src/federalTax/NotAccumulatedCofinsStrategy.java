package federalTax;

import abstracts.COFINS;
import concrete.Income;

public class NotAccumulatedCofinsStrategy extends COFINS {

	@Override
	public double calcule() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calcule(Income income) {
		return partialCofins(income) - totalCredit(income);

	}

	public double partialCofins(Income income) {
		return income.getMonthlyIncome() * 0.076;
	}

	public double totalCredit(Income income) {
		return income.getAccreditedPurchase() * 0.076;
	}

}
