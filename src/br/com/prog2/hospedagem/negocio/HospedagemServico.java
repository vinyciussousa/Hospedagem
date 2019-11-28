package br.com.prog2.hospedagem.negocio;

import java.time.LocalDate;

public class HospedagemServico {
	private String codHospedagem;
	private LocalDate dataServico;
	private String codServico;
	private Double valorServico;
	
	public String getCodHospedagem() {
		return codHospedagem;
	}
	
	public LocalDate getDataServico() {
		return dataServico;
	}
	
	public String getCodServico() {
		return codServico;
	}
	
	public Double getValorServico() {
		return valorServico;
	}
	
	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	
	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}
	
	public void setCodServico(String codServico) {
		this.codServico = codServico;
	}
	
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
}
