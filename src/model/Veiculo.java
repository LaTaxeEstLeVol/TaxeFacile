package model;

public class Veiculo extends Produto {
	
	private String tipoCombustivel = "";

	public Veiculo () {
		
	}
	
	public Veiculo(String combustivel) {
		
	}
	
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
}
