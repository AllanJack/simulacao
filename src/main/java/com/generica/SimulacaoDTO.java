package com.generica;

public class SimulacaoDTO {
	
	String valorParcela;
	String tipoSeguro;
	String quantidadeParcelas;
	String taxaJuros;
	String totalPagar;
	
	public String getValorParcela() {
		return "500.00";
	}
	public void setValorParcela(String valorParcela) {
		this.valorParcela = valorParcela;
	}
	public String getTipoSeguro() {
		return "com_seguro";
	}
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public String getQuantidadeParcelas() {
		return "10";
	}
	public void setQuantidadeParcelas(String quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public String getTaxaJuros() {
		return "3.75";
	}
	public void setTaxaJuros(String taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public String getTotalPagar() {
		return "5845.56";
	}
	public void setTotalPagar(String totalPagar) {
		this.totalPagar = totalPagar;
	}
}
