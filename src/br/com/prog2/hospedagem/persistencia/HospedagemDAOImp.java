package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO{
	@Override
	public String hospedar(Hospedagem Hos) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagem(codhospedagem,codchale,codcliente,estado,datainicio,datafim,qtdpessoas,desconto,valorfinal) values(?,?,?,?,?,?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, Hos.getCodHospedagem());
			pst.setString(2, Hos.getCodChale());
			pst.setString(3, Hos.getCodCliente());
			pst.setString(4, Hos.getEstado());
			pst.setObject(5, Hos.getDataInicio());
			pst.setObject(6, Hos.getDataFim());
			pst.setInt(7, Hos.getQtdPessoas());
			pst.setDouble(8, Hos.getDesconto());
			pst.setDouble(9, Hos.getValorFinal());
			LocalDate marca = Hos.getDataInicio();
			LocalDate marca2 = Hos.getDataFim();
			LocalDate now = LocalDate.now();
			List<Hospedagem> lista = new ArrayList<>();
			lista = pesquisarPorCodChale(Hos.getCodChale());
			if(lista != null) {
				for(Hospedagem e : lista) {
					if(marca.compareTo(e.getDataFim()) <= 0 && marca.compareTo(e.getDataInicio()) >= 0) { //Caso o Chale em questao esteja ocupado.
						return "Erro ao inserir.";
					}
					else if(marca2.compareTo(e.getDataFim()) <= 0 && marca2.compareTo(e.getDataInicio()) >= 0){ //Caso o Chale em questao esteja ocupado.
						return "Erro ao inserir.";
					}
				}
			}
			
			if(now.compareTo(Hos.getDataFim()) > 0) { //Caso a data de hoje seja depois do tempo de tentativa de se hospedar.
				return "Erro ao inserir.";
			}
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} 
			else {
				return "Erro ao inserir.";
			}
		} 
		catch (SQLException e) {
			return e.getMessage();
		}
		finally {
			ConnectionFactory.close(con);
		}
	}

	public String excluir(Hospedagem Hos) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from hospedagem where codhospedagem=?");
		Connection con = ConnectionFactory.getConnection();
		try {
		PreparedStatement pst = con.prepareStatement(sql.toString());
		pst.setString(1, Hos.getCodHospedagem());
		int res = pst.executeUpdate();
		if (res > 0) {
		return "Excluido com sucesso.";
		} else {
		return "Erro ao excluir.";
		}
		} catch (SQLException e) {
		return e.getMessage();
		} finally {
		ConnectionFactory.close(con);
		}
	}

	public String alterar(Hospedagem Hos) {
		StringBuilder sql = new StringBuilder();
		sql.append("update hospedagem set codchale=?,codcliente=?,estado=?,datainicio=?,datafim=?,qtdpessoas=?,desconto=?,valorfinal=? where codhospedagem=? ");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, Hos.getCodChale());
			pst.setString(2, Hos.getCodCliente());
			pst.setString(3, Hos.getEstado());
			pst.setObject(4, Hos.getDataInicio());
			pst.setObject(5, Hos.getDataFim());
			pst.setInt(6, Hos.getQtdPessoas());
			pst.setDouble(7, Hos.getDesconto());
			pst.setDouble(8, Hos.getValorFinal());
			pst.setString(9, Hos.getCodHospedagem());
			LocalDate marca = Hos.getDataInicio();
			LocalDate marca2 = Hos.getDataFim();
			LocalDate now = LocalDate.now();
			List<Hospedagem> lista = new ArrayList<>();
			lista = pesquisarPorCodChale(Hos.getCodChale());
			if(lista != null) {
				for(Hospedagem e : lista) {
					if(marca.compareTo(e.getDataFim()) <= 0 && marca.compareTo(e.getDataInicio()) >= 0 && e.getCodHospedagem() != Hos.getCodHospedagem()) {
						return "Erro ao inserir.";
					}
					else if(marca2.compareTo(e.getDataFim()) <= 0 && marca2.compareTo(e.getDataInicio()) >= 0 && e.getCodHospedagem() != Hos.getCodHospedagem()){
						return "Erro ao inserir.";
					}
					else if(e.getCodHospedagem() == Hos.getCodHospedagem() && e.getCodCliente() != Hos.getCodCliente()) {
						return "Erro ao inserir.";
					}
				}
			}
			
			if(now.compareTo(Hos.getDataFim()) > 0) { //Caso a data de hoje seja depois do tempo de tentativa de se hospedar.
				return "Erro ao inserir.";
			}
			int res = pst.executeUpdate();
			if (res > 0) {
			return "Alterado com sucesso.";
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
	public List<Hospedagem> listarTodos() {
		String sql = "select * from hospedagem";
		List<Hospedagem> lista = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Hospedagem Hos = new Hospedagem();
					Hos.setCodHospedagem(rs.getString(1));
					Hos.setCodChale(rs.getString(2));
					Hos.setCodCliente(rs.getString(3));
					Hos.setEstado(rs.getString(4));
					Hos.setDataInicio(rs.getObject(5, LocalDate.class));
					Hos.setDataFim(rs.getObject(6, LocalDate.class));
					Hos.setQtdPessoas(rs.getInt(7));
					Hos.setDesconto(rs.getDouble(8));
					Hos.setValorFinal(rs.getDouble(9));
					lista.add(Hos);
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
	public List<Hospedagem> pesquisarPorCodCliente(String codCliente) {
		String sql = "select * from hospedagem where codcliente=?";
		List<Hospedagem> lista = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Hospedagem Hos = new Hospedagem();
					Hos.setCodHospedagem(rs.getString(1));
					Hos.setCodChale(rs.getString(2));
					Hos.setCodCliente(rs.getString(3));
					Hos.setEstado(rs.getString(4));
					Hos.setDataInicio(rs.getObject(5, LocalDate.class));
					Hos.setDataFim(rs.getObject(6, LocalDate.class));
					Hos.setQtdPessoas(rs.getInt(7));
					Hos.setDesconto(rs.getDouble(8));
					Hos.setValorFinal(rs.getDouble(9));
					lista.add(Hos);
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
	public List<Hospedagem> pesquisarPorCodChale(String codChale) {
		String sql = "select * from hospedagem where codchale=?";
		List<Hospedagem> lista = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					Hospedagem Hos = new Hospedagem();
					Hos.setCodHospedagem(rs.getString(1));
					Hos.setCodChale(rs.getString(2));
					Hos.setCodCliente(rs.getString(3));
					Hos.setEstado(rs.getString(4));
					Hos.setDataInicio(rs.getObject(5, LocalDate.class));
					Hos.setDataFim(rs.getObject(6, LocalDate.class));
					Hos.setQtdPessoas(rs.getInt(7));
					Hos.setDesconto(rs.getDouble(8));
					Hos.setValorFinal(rs.getDouble(9));
					lista.add(Hos);
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
	public Hospedagem pesquisarPorCodHospedagem(String codHospedagem) {
		String sql = "select * from hospedagem where codhospedagem=?";
		Connection con = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codHospedagem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Hospedagem Hos = new Hospedagem();
				Hos.setCodHospedagem(rs.getString(1));
				Hos.setCodChale(rs.getString(2));
				Hos.setCodCliente(rs.getString(3));
				Hos.setEstado(rs.getString(4));
				Hos.setDataInicio(rs.getObject(5, LocalDate.class));
				Hos.setDataFim(rs.getObject(6, LocalDate.class));
				Hos.setQtdPessoas(rs.getInt(7));
				Hos.setDesconto(rs.getDouble(8));
				Hos.setValorFinal(rs.getDouble(9));
				return Hos;
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
