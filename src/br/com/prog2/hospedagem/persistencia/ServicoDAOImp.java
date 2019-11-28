package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.Servico;
import br.com.prog2.hospedagem.negocio.Telefone;

public class ServicoDAOImp implements ServicoDAO{

	@Override
	public String inserir(Servico s) {
		String sql = "insert into servico(codservico,nomeservico,valorservico) values (?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getCodServico());
			pst.setString(2, s.getNomeServico());
			pst.setDouble(3, s.getValorServico());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Sucesso ao inserir.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Servico s) {
		String sql = "delete from servico where codservico=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getCodServico());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Sucesso ao excluir.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Servico> listarTodos() {
		String sql = "select * from servico";
		Connection con = ConnectionFactory.getConnection();
		List<Servico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Servico i = new Servico();
					i.setCodServico(rs.getString(1));
					i.setNomeServico(rs.getString(2));
					i.setValorServico(rs.getDouble(3));
					lista.add(i);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public Servico pesquisarPorServico(String codServico) {
		String sql = "select * from Servico where codServico=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codServico);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Servico i = new Servico();
				i.setCodServico(rs.getString(1));
				i.setNomeServico(rs.getString(2));
				i.setValorServico(rs.getDouble(3));
				return i;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
}
