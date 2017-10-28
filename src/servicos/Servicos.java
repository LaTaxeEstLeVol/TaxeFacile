package servicos;

import abstratas.TemplateDeImposto;
import impostosFederais.INSS;
import model.Produto;

public class Servicos {
	
	public double calculaINSS() {
		
		Validacoes validacoes = new Validacoes();
		Produto produto = new Produto();
		
		produto.setValor(validacoes.validaValor());
		
		TemplateDeImposto templateDeImposto = new INSS();
		System.out.println(templateDeImposto.calcula(produto));
		return 0;
	}
}
