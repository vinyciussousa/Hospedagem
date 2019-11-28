package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.HospedagemServico;

public class HospedagemServicoDAOImp implements HospedagemServicoDAO{

	@Override
	public String inserir(HospedagemServico hs) {
		String sql = "insert into hospedagemservico(codhospedagem,dataservico,codservico,valorservico) values (?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, hs.getCodHospedagem());
			pst.setObject(2, hs.getDataServico());
			pst.setString(3, hs.getCodServico());
			pst.setDouble(4, hs.getValorServico());
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
	public String excluir(HospedagemServico hs) {
		String sql = "delete from hospedagemservico where codservico=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, hs.getCodServico());
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
	public List<HospedagemServico> listarTodos() {
		String sql = "select * from hospedagemservico";
		Connection con = ConnectionFactory.getConnection();
		List<HospedagemServico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					HospedagemServico i = new HospedagemServico();
					i.setCodHospedagem(rs.getString(1));
					i.setDataServico(rs.getObject(2, LocalDate.class));
					i.setCodServico(rs.getString(3));
					i.setValorServico(rs.getDouble(4));
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
