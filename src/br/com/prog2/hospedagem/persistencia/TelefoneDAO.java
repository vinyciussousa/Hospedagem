package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Telefone;

public interface TelefoneDAO {
	public String inserir(Telefone t);
	public String excluir(Telefone t);
	public List<Telefone> listarTodos();
	public List<Telefone> pesquisarPorCodCliente(String codCliente);
	public Telefone pesquisarPorTelefone(String Telefone);
}
