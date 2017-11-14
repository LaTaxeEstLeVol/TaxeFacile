package services;

import java.text.DecimalFormat;

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
		return valid;
	}
	
	public boolean validateSalary(String value) {
		
		double finalValue = 0.0;
		boolean valid = true;
		
		try {
			if(value.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Insira o salário bruto ");
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
		return valid;
	}
	
	public boolean validateMonths(String value) {
		
		double month = 1;
		boolean valid = true;
		
		try {
			if(value.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Insira a quantidade de meses trabalhados");
				valid = false;
			}
			month = Double.parseDouble(value);
			valid = true;
			while(month <= 0 || month >2442) {
				JOptionPane.showMessageDialog(null, "Informe um número positivo e maior que 0");
			}
		}catch (NumberFormatException numberFormatException) {
			JOptionPane.showMessageDialog(null, "Informe um número numerico e positivo");
			valid = false;
		}
		return valid;
	}
	
	public String format(double value) {
		
		String format = "#.##";
		DecimalFormat decimalFormat = new DecimalFormat(format);
		
		return decimalFormat.format(value);
	}
}
