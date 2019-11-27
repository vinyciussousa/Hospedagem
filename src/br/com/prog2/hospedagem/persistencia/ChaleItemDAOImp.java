package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.ChaleItem;

public class ChaleItemDAOImp implements ChaleItemDAO{

	@Override
	public String inserir(ChaleItem ci) {
		String sql = "insert into chaleitem(codchale,nomeitem) values (?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ci.getCodChale());
			pst.setString(2, ci.getNomeItem());
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
	public String excluir(ChaleItem ci) {
		String sql = "delete from chaleitem where codchale=? AND nomeitem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ci.getCodChale());
			pst.setString(2, ci.getNomeItem());
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
	public List<ChaleItem> listarTodos() {
		String sql = "select * from chaleitem";
		Connection con = ConnectionFactory.getConnection();
		List<ChaleItem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					ChaleItem ci = new ChaleItem();
					ci.setCodChale(rs.getString(1));
					ci.setNomeItem(rs.getString(2));
					lista.add(ci);
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
