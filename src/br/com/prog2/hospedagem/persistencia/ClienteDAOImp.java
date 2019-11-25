package br.com.prog2.hospedagem.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.hospedagem.negocio.Cliente;

public class ClienteDAOImp implements ClienteDAO {
	@Override
	public String inserir(Cliente cli) {
		String sql = "insert into cliente(codcliente,nomecliente,rgcliente,enderecocliente,bairrocliente,cidadecliente,estadocliente,cepcliente,nascimentocliente) values(?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cli.getCodCliente());
			pst.setString(2, cli.getNomeCliente());
			pst.setString(3, cli.getRgCliente());
			pst.setString(4, cli.getEnderecoCliente());
			pst.setString(5, cli.getBairroCliente());
			pst.setString(6, cli.getCidadeCliente());
			pst.setString(7, cli.getEstadoCliente());
			pst.setString(8, cli.getCEPCliente());
			pst.setDate(9, cli.getNascimentoCliente());
			int res = pst.executeUpdate();
			if(res > 0){
				return "Inserido com sucesso.";
			}
			else{
				return "Erro ao inserir.";
			}
			}
			catch(SQLException e){
				return e.getMessage();
			}
			finally {
			ConnectionFactory.close(con);
			}
	}
	@Override
	public String alterar(Cliente cli) {
		String sql = "update cliente set nomecliente=?,rgcliente=?,enderecocliente=?,bairrocliente=?,cidadecliente=?,estadocliente=?,cepcliente=?,nascimentocliente=? where codcliente=?";
		Connection con = ConnectionFactory.getConnection();
		try{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, cli.getNomeCliente());
		pst.setString(2, cli.getRgCliente());
		pst.setString(3, cli.getEnderecoCliente());
		pst.setString(4, cli.getBairroCliente());
		pst.setString(5, cli.getCidadeCliente());
		pst.setString(6, cli.getEstadoCliente());
		pst.setString(7, cli.getCEPCliente());
		pst.setDate(8, cli.getNascimentoCliente());
		pst.setString(9, cli.getCodCliente());
		int res = pst.executeUpdate();
		if(res > 0){
		return "Alterado com sucesso.";
		}else{
		return "Erro ao alterar.";
		}
		}catch(SQLException e){
		return e.getMessage();
		}finally {
		ConnectionFactory.close(con);
		}
	}
	@Override
	public String excluir(Cliente cli) {
		String sql = "delete from cliente where codcliente=?";
		Connection con = ConnectionFactory.getConnection();
		try{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, cli.getCodCliente());
		int res = pst.executeUpdate();
		if(res > 0){
		return "Excluido com sucesso.";
		}else{
		return "Erro ao excluir.";
		}
		}catch(SQLException e){
		return e.getMessage();
		}finally {
		ConnectionFactory.close(con);
		}
	}
	@Override
	public List<Cliente> listarTodos() {
		String sql = "select * from cliente";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs != null) {
		while (rs.next()) {
		Cliente cli = new Cliente();
		cli.setCodCliente(rs.getString(1));
		cli.setNomeCliente(rs.getString(2));
		cli.setRgCliente(rs.getString(3));
		cli.setEnderecoCliente(rs.getString(4));
		cli.setBairroCliente(rs.getString(5));
		cli.setCidadeCliente(rs.getString(6));
		cli.setEstadoCliente(rs.getString(7));
		cli.setCEPCliente(rs.getString(8));
		cli.setNascimentoCliente(rs.getDate(9));
		lista.add(cli);
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
	public Cliente pesquisarPorCodigo(String codCliente) {
		String sql = "select * from cliente where codcliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, codCliente);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
		Cliente cli = new Cliente();
		cli.setCodCliente(rs.getString(1));
		cli.setNomeCliente(rs.getString(2));
		cli.setRgCliente(rs.getString(3));
		cli.setEnderecoCliente(rs.getString(4));
		cli.setBairroCliente(rs.getString(5));
		cli.setCidadeCliente(rs.getString(6));
		cli.setEstadoCliente(rs.getString(7));
		cli.setCEPCliente(rs.getString(8));
		cli.setNascimentoCliente(rs.getDate(9));
		return cli;
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
