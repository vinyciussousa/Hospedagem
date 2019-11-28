package br.com.prog2.hospedagem.negocio;

public class Servico {
	private String codServico;
	private String nomeServico;
	private Double valorServico;
	
	public String getCodServico() {
		return codServico;
	}
	
	public String getNomeServico() {
		return nomeServico;
	}
	
	public Double getValorServico() {
		return valorServico;
	}
	
	public void setCodServico(String codServico) {
		this.codServico = codServico;
	}
	
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
}
