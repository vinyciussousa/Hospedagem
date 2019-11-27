package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Item;

public interface ItemDAO {
	public String inserir(Item i);
	public String excluir(Item i);
	public List<Item> listarTodos();
	public Item procurarPorNome(String nomeItem);
}
