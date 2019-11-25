package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Cliente;
import br.com.prog2.hospedagem.persistencia.ClienteDAOImp;

public class ClienteController {
	public String inserir(Cliente cli){
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(cli);
		}
		public String alterar(Cliente cli) {
			ClienteDAOImp dao = new ClienteDAOImp();
			return dao.alterar(cli);
		}
		public String excluir(Cliente cli){
			ClienteDAOImp dao = new ClienteDAOImp();
			return dao.excluir(cli);
		}
		public List<Cliente> listarTodos(){
			ClienteDAOImp dao = new ClienteDAOImp();
			return dao.listarTodos();
		}
		public Cliente pesquisarPorCod(String codCliente){
			ClienteDAOImp dao = new ClienteDAOImp();
			return dao.pesquisarPorCodigo(codCliente);
		}
}
