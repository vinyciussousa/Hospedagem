package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.Chale;

public class ChaleDAOImp implements ChaleDAO{

	@Override
	public String inserir(Chale cha) {
		String sql = "insert into chale(codchale,localizacao,capacidade,valoraltaestacao,valorbaixaestacao) values (?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cha.getCodChale());
			pst.setString(2, cha.getLocalizacao());
			pst.setInt(3, cha.getCapacidade());
			pst.setDouble(4, cha.getValorAltaEstacao());
			pst.setDouble(5, cha.getValorBaixaEstacao());
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
	public String alterar(Chale cha) {
		String sql = "update chale set codchale=?,localizacao=?,capacidade=?,valoraltaestacao=?,valorbaixaestacao=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cha.getCodChale());
			pst.setString(2, cha.getLocalizacao());
			pst.setInt(3, cha.getCapacidade());
			pst.setDouble(4, cha.getValorAltaEstacao());
			pst.setDouble(5, cha.getValorBaixaEstacao());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Sucesso ao alterar.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Chale cha) {
		String sql = "delete from chale where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cha.getCodChale());
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
	public List<Chale> listarTodos() {
		String sql = "select * from chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Chale cha = new Chale();
					cha.setCodChale(rs.getString(1));
					cha.setLocalizacao(rs.getString(2));
					cha.setCapacidade(rs.getInt(3));
					cha.setValorAltaEstacao(rs.getDouble(4));
					cha.setValorBaixaEstacao(rs.getDouble(5));
					lista.add(cha);
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
	public Chale pesquisarPorCodigo(String codChale) {
		String sql = "select * from chale where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale cha = new Chale();
				cha.setCodChale(rs.getString(1));
				cha.setLocalizacao(rs.getString(2));
				cha.setCapacidade(rs.getInt(3));
				cha.setValorAltaEstacao(rs.getDouble(4));
				cha.setValorBaixaEstacao(rs.getDouble(5));
				return cha;
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
