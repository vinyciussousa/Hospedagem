package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Chale;

public interface ChaleDAO {
	public String inserir(Chale cha);
	public String alterar(Chale cha);
	public String excluir(Chale cha);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodigo(String codChale);
}
