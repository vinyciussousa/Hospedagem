package br.com.prog2.hospedagem.controller;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Hospedagem;
import br.com.prog2.hospedagem.persistencia.HospedagemDAOImp;

public class HospedagemController {
	public String inserir(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.hospedar(hos);
	}
	public String alterar(Hospedagem dep) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(dep);
	}
	public String excluir(Hospedagem dep) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(dep);
	}
	public List<Hospedagem> listarTodos() {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodos();
	}
	public List<Hospedagem> pesquisarPorCodCliente(String codCliente) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodCliente(codCliente);
	}
	public List<Hospedagem> pesquisarPorCodChale(String codChale){
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodChale(codChale);
	}
	public Hospedagem pesquisarPorCodHospedagem(String codHospedagem) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodHospedagem(codHospedagem);
	}
}
