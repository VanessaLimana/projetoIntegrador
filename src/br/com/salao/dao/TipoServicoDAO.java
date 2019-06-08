package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dto.TipoServicoDTO;

public class TipoServicoDAO {

	private static final String tbl_name = "tiposervico";
	private static final String sql_insert = "INSERT INTO " + tbl_name
			+ " ( descricao) VALUES (?)";
	private static final String sql_update = "UPDATE tiposervico SET descricaoserv = ?, WHERE id = ?";
	private static final String sql_delete = "DELETE FROM tiposervico WHERE id = ?";
	private static final String sql_select = "SELECT * FROM tiposervico";
	private static final String sql_by_id = "SELECT * FROM tiposervico WHERE id = ?";
	private Connection conn = null;

	public TipoServicoDAO() {
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean insert(TipoServicoDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_insert);
		pstm.setString(1, dto.getDescricaoserv());
		return (pstm.executeUpdate() > 0);
	}

	public boolean update(TipoServicoDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_update);
		pstm.setString(1, dto.getDescricaoserv());
		pstm.setInt(2, dto.getId());
		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public boolean delete(TipoServicoDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_delete);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public List<TipoServicoDTO> getAll() throws SQLException {
		try {
			List<TipoServicoDTO> lista = new ArrayList<TipoServicoDTO>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql_select);
			while (rs.next()) {
				TipoServicoDTO dto = new TipoServicoDTO(rs.getInt("id"), rs.getString("descricaoserv"));
				lista.add(dto);
			}

			return lista;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
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
