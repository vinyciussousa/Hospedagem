package br.com.prog2.hospedagem.negocio;

import java.sql.Date;

public class Hospedagem {
	private String codHospedagem;
	private String codChale;
	private String estado;
	private Date dataInicio;
	private Date dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;
	
	public String getCodHospedagem() {
		return codHospedagem;
	}
	
	public String getCodChale() {
		return codChale;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public Integer getQtdPessoas() {
		return qtdPessoas;
	}
	
	public Double getDesconto() {
		return desconto;
	}
	
	public Double getValorFinal() {
		return valorFinal;
	}
	
	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	
	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
}
