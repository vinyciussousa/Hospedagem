package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.HospedagemServico;
import br.com.prog2.hospedagem.persistencia.HospedagemServicoDAOImp;

public class HospedagemServicoController {
	public String inserir(HospedagemServico hs) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.inserir(hs);
	}
	
	public String excluir(HospedagemServico hs) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.excluir(hs);
	}
	
	public List<HospedagemServico> listarTodos(){
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.listarTodos();
	}
}
