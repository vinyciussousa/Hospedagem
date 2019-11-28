package br.com.prog2.hospedagem.negocio;

public class Telefone {
	private String telefone;
	private String codCliente;
	private String tipoTelefone;
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getCodCliente() {
		return codCliente;
	}
	
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	
	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
