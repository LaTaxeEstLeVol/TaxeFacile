package abstratas;

import model.Produto;

public abstract class TemplateDeImposto extends Imposto {

	@Override
	public double calcula(Produto produto) {
		if(usarMaximaTaxacao(produto)) {
			return maximaTaxacao(produto);
		} else if(usarTaxacaoMedia(produto)){
			return taxacaoMedia(produto);
		} else {
			return minimaTaxacao(produto);
		}
	}
	
	public abstract double minimaTaxacao(Produto produto);
	public abstract double taxacaoMedia(Produto produto);
	public abstract double maximaTaxacao(Produto produto);
	public abstract boolean usarMaximaTaxacao(Produto produto);
	public abstract boolean usarTaxacaoMedia(Produto produto);
}
