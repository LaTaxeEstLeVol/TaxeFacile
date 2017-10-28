package controller;

import servicos.Servicos;
import view.Visao;

public class Main {

	public static void main(String[] args) {
		
		int opcao = 0;
		int escolha = 0;
		Visao visao = new Visao();
		Servicos servicos = new Servicos();
		
		opcao = visao.mostraMenu();
		switch(opcao) {
			case 0:
				escolha = visao.mostraImpostosFederais();
				switch(escolha) {
					case 0:
						servicos.calculaINSS();
					break;
				}	
			break;
		}
	}
}
