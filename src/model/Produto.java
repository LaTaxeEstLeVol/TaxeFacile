package model;

public class Produto {
	
	private double aliquota = 0.0;
	private double valor = 0.0;
	private String estado = "";
	private String name = "";
	
	public Produto () {
		
	}
	
	public Produto(String name,double valor,String estado) {
		setName(name);
		setValor(valor);
		setEstado(estado);
	}
	
	public Produto(double valor) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}