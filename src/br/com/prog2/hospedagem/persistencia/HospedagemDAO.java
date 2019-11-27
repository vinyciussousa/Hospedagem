package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Hospedagem;

public interface HospedagemDAO {
	public String hospedar(Hospedagem Hos);
	public String excluir(Hospedagem Hos);
	public String alterar(Hospedagem Hos);
	public List<Hospedagem> listarTodos();
	public List<Hospedagem> pesquisarPorCodCliente(String codCliente);
	public List<Hospedagem> pesquisarPorCodChale(String codChale);
	public Hospedagem pesquisarPorCodHospedagem(String codHospedagem);
}
