package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.ChaleItem;

public interface ChaleItemDAO {
	public String inserir(ChaleItem ci);
	public String excluir(ChaleItem ci);
	public List<ChaleItem> listarTodos();
}
