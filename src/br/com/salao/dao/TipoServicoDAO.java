package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dto.TipoServicoDTO;
import br.com.salao.dto.TipoServicoDTO;

public class TipoServicoDAO {

	private static final String tbl_name = "tiposervico";
	private static final String sql_insert = "INSERT INTO " + tbl_name
			+ " (descricaoserv) VALUES (?)";
	private static final String sql_update = "UPDATE tiposervico SET descricaoserv = ?, WHERE id = ?";
	private static final String sql_delete = "DELETE FROM tiposervico WHERE id = ?";
	private static final String sql_select = "SELECT * FROM tiposervico";
	private static final String sql_by_id = "SELECT * FROM tiposervico WHERE id = ?";
	
	private Connection conn = null;
	private Object connection;

	public TipoServicoDAO() {		
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<TipoServicoDTO> findAll() {
		String sql = "SELECT * FROM tipoServico ";
		
		List<TipoServicoDTO> tipoServicos = new ArrayList<TipoServicoDTO>();
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				tipoServicos.add(new TipoServicoDTO(result));
			}

		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return tipoServicos;
	}
	
	public TipoServicoDTO findById(int id) {
		String sql = "SELECT * FROM tipoServico WHERE id = ?";

		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			TipoServicoDTO tipoServicoDTO = new TipoServicoDTO(result);
			
			return tipoServicoDTO;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	/*
	 * public TipoServicoDTO(int id, String nome, String endereco, String email,
	 * String cpf, String sexo, String senha,String telefone, String cargo){
	 */
	public boolean insert(TipoServicoDTO dto) throws SQLException{
		
		PreparedStatement pstm = conn.prepareStatement(sql_insert);
		pstm.setString(1, dto.getDescricaoserv());


		return (pstm.executeUpdate() > 0);
	}
	public boolean update(TipoServicoDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_update);

		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public boolean delete(TipoServicoDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_delete);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public TipoServicoDTO getById(int id) {
		try {
			TipoServicoDTO dto = null;
			PreparedStatement pstm = conn.prepareStatement(sql_by_id);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			if (rs.first()) {
				dto = new TipoServicoDTO(rs.getInt("id"), rs.getString("descricaoserv"));

			}

			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static List<TipoServicoDTO> getListarTipoServicos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}