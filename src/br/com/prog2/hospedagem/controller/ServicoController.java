package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Servico;
import br.com.prog2.hospedagem.negocio.Telefone;
import br.com.prog2.hospedagem.persistencia.ServicoDAOImp;
import br.com.prog2.hospedagem.persistencia.TelefoneDAOImp;
public class ServicoController {
	public String inserir(Servico s) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.inserir(s);
	}
	
	public String excluir(Servico s) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.excluir(s);
	}
	
	public List<Servico> listarTodos(){
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.listarTodos();
	}
	
	public Servico pesquisarPorServico(String codServico) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.pesquisarPorServico(codServico);
	}
}
