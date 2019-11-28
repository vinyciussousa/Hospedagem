package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.HospedagemServico;

public interface HospedagemServicoDAO {
	public String inserir(HospedagemServico hs);
	public String excluir(HospedagemServico hs);
	public List<HospedagemServico> listarTodos();
}
