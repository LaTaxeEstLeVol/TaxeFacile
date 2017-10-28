package view;

import javax.swing.JOptionPane;

import abstratas.Imposto;
import model.Produto;

/*
 * esse extends de imposto só ta servindo como um exemplo ja que no final tem o calcular que ta vindo de calculavel
 * e passando por imposto
 */

public class Visao extends Imposto{
	
	public int mostraMenu() {
		
		String opcoes[] = {"Federal","Munipal","Estadual"};
		int opcao = 0;
		
		opcao = JOptionPane.showOptionDialog(null, "Clique em um ramo", "Menu de Impostos",0,JOptionPane.INFORMATION_MESSAGE,
											null, opcoes, opcoes[0]);
		return opcao;
	}
	
	public int mostraImpostosFederais() {
		
		String opcoes[] = {"INSS"};
		int opcao = 0;
		
		opcao = JOptionPane.showOptionDialog(null, "Clique em um impostos", "Menu de Impostos",0,JOptionPane.INFORMATION_MESSAGE,
											null, opcoes, opcoes[0]);
		return opcao;
	}
	
	@Override
	public double calcula(Produto produto) {
		// TODO Auto-generated method stub
		return 0;
	}
}
