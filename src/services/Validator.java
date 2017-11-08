package services;

import javax.swing.JOptionPane;

public class Validator {
	
	public boolean validateProfit(String value,String trimester) {
		
		double finalValue = 0.0;
		boolean valid = true;
		
		try {
			if(value.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Insira o valor trimestral " + trimester);
				valid = false;
			}
			finalValue = Double.parseDouble(value);
			valid = true;
			while(finalValue <= 0) {
				JOptionPane.showMessageDialog(null, "Informe um número positivo e maior que 0");
			}
		}catch (NumberFormatException numberFormatException) {
			JOptionPane.showMessageDialog(null, "Informe um número numerico e positivo");
			valid = false;
		}
		/*do {
			try {
				finalValue = Double.parseDouble(value);
				valid = true;
				while(finalValue <= 0) {
					JOptionPane.showMessageDialog(null, "Informe um número positivo e maior que 0");
				}
			}catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Informe um número numerico e positivo");
				valid = false;
			}
		}while(valid == false);*/
		
		return valid;
	}
}
