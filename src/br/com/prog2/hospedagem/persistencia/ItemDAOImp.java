package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.Item;

public class ItemDAOImp implements ItemDAO{

	@Override
	public String inserir(Item i) {
		String sql = "insert into item(nomeitem,descricaoitem) values (?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, i.getNomeItem());
			pst.setString(2, i.getDescricaoItem());
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
	public String excluir(Item i) {
		String sql = "delete from item where nomeitem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, i.getNomeItem());
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
	public List<Item> listarTodos() {
		String sql = "select * from item";
		Connection con = ConnectionFactory.getConnection();
		List<Item> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Item i = new Item();
					i.setNomeItem(rs.getString(1));
					i.setDescricaoItem(rs.getString(2));
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
	public Item procurarPorNome(String nomeItem) {
		String sql = "select * from item where nomeitem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, nomeItem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Item i = new Item();
				i.setNomeItem(rs.getString(1));
				i.setDescricaoItem(rs.getString(2));
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
