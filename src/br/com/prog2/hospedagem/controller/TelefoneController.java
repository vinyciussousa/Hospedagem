package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Telefone;
import br.com.prog2.hospedagem.persistencia.TelefoneDAOImp;

public class TelefoneController {
	public String inserir(Telefone i) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.inserir(i);
	}
	
	public String excluir(Telefone i) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.excluir(i);
	}
	
	public List<Telefone> pesquisarPorCodCliente(String codCliente) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.pesquisarPorCodCliente(codCliente);
	}
	
	public Telefone pesquisarPorTelefone(String Telefone) {
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.pesquisarPorTelefone(Telefone);
	}
	
	public List<Telefone> listarTodos(){
		TelefoneDAOImp dao = new TelefoneDAOImp();
		return dao.listarTodos();
	}
}
