package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.ChaleItem;
import br.com.prog2.hospedagem.persistencia.ChaleItemDAOImp;

public class ChaleItemController {
	public String inserir(ChaleItem ci) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.inserir(ci);
	}
	
	public String excluir(ChaleItem ci) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.excluir(ci);
	}
	
	public List<ChaleItem> listarTodos(){
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.listarTodos();
	}
}
