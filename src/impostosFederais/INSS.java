package impostosFederais;

import abstratas.TemplateDeImposto;
import model.Produto;

public class INSS extends TemplateDeImposto {

	@Override
	public double minimaTaxacao(Produto produto) {
		
		double aliquota = (double) 8/100;
		produto.setAliquota(aliquota);
		return produto.getValor() * produto.getAliquota();
	}

	@Override
	public double taxacaoMedia(Produto produto) {
		
		double aliquota = (double) 9/100;
		produto.setAliquota(aliquota);
		return produto.getValor() * produto.getAliquota();
	}

	@Override
	public double maximaTaxacao(Produto produto) {
		
		double aliquota = (double) 11/100;
		produto.setAliquota(aliquota);
		return produto.getValor() * produto.getAliquota();
	}

	@Override
	public boolean usarMaximaTaxacao(Produto produto) {
		
		boolean valid = true;
		
		if(produto.getValor() >= 2594.93 && produto.getValor() <= 5189.82) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	@Override
	public boolean usarTaxacaoMedia(Produto produto) {
		
		boolean valid = true;
		
		if(produto.getValor() >= 1556.95 && produto.getValor() <= 2594.92) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
}