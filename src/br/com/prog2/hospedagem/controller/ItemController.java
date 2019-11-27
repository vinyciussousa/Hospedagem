package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Item;
import br.com.prog2.hospedagem.persistencia.ItemDAOImp;

public class ItemController {
	public String inserir(Item i) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.inserir(i);
	}
	
	public String excluir(Item i) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.excluir(i);
	}
	
	public List<Item> listarTodos(){
		ItemDAOImp dao = new ItemDAOImp();
		return dao.listarTodos();
	}
	
	public Item procurarPorNome(String nomeItem) {
		ItemDAOImp dao = new ItemDAOImp();
		return dao.procurarPorNome(nomeItem);
	}
}
