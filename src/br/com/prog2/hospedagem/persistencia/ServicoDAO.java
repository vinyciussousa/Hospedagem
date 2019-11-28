package br.com.prog2.hospedagem.persistencia;

import java.util.List;

import br.com.prog2.hospedagem.negocio.Servico;
import br.com.prog2.hospedagem.negocio.Telefone;


public interface ServicoDAO {
	public String inserir(Servico s);
	public String excluir(Servico s);
	public List<Servico> listarTodos();
	public Servico pesquisarPorServico(String codServico);
}
