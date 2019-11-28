package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.Telefone;

public class TelefoneDAOImp implements TelefoneDAO{

	@Override
	public String inserir(Telefone t) {
		String sql = "insert into telefone(telefone,codcliente,tipotelefone) values (?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTelefone());
			pst.setString(2, t.getCodCliente());
			pst.setString(3, t.getTipoTelefone());
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
	public String excluir(Telefone t) {
		String sql = "delete from telefone where telefone=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTelefone());
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
	public List<Telefone> pesquisarPorCodCliente(String codCliente) {
		String sql = "select * from telefone where codcliente=?";
		List<Telefone> lista = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Telefone t = new Telefone();
					t.setTelefone(rs.getString(1));
					t.setCodCliente(rs.getString(2));
					t.setTipoTelefone(rs.getString(3));
					lista.add(t);
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
	public Telefone pesquisarPorTelefone(String Telefone) {
		String sql = "select * from telefone where telefone=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Telefone);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Telefone i = new Telefone();
				i.setTelefone(rs.getString(1));
				i.setCodCliente(rs.getString(2));
				i.setTipoTelefone(rs.getString(3));
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

	@Override
	public List<Telefone> listarTodos() {
		String sql = "select * from telefone";
		Connection con = ConnectionFactory.getConnection();
		List<Telefone> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Telefone i = new Telefone();
					i.setTelefone(rs.getString(1));
					i.setCodCliente(rs.getString(2));
					i.setTipoTelefone(rs.getString(3));
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

}
