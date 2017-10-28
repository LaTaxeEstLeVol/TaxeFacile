package servicos;

import javax.swing.JOptionPane;

public class Validacoes {
	
	public double validaValor() {
		
		boolean valid = true;
		double valor = 0.0;
		
		do {
			try {
				valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe um valor","",
											JOptionPane.QUESTION_MESSAGE));
				while(valor <= 0) {
					JOptionPane.showMessageDialog(null, "Informe um valor positivo e superior a 0 !",
												"Valor negativo ou nulo",JOptionPane.ERROR_MESSAGE);
					valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe um valor","",
							JOptionPane.QUESTION_MESSAGE));
					valid = true;
				}
			}catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Valor inválido! Informe um valor númerico",
												"Erro na informação",JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		} while(valid == false);
		
		return valor;
	}
}
