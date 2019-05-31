package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dto.TipoProdutoDTO;

public class TipoProdutoDAO {

	private static final String tbl_name = "tipoProdutos";
	private static final String sql_insert = "INSERT INTO " + tbl_name
			+ " ( descricao) VALUES (?)";
	private static final String sql_update = "UPDATE tipoProdutos SET descricao = ?, WHERE id = ?";
	private static final String sql_delete = "DELETE FROM tipoProdutos WHERE id = ?";
	private static final String sql_select = "SELECT * FROM tipoProdutos";
	private static final String sql_by_id = "SELECT * FROM tipoProdutos WHERE id = ?";
	private Connection conn = null;

	public TipoProdutoDAO() {
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean insert(TipoProdutoDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_insert);
		pstm.setString(1, dto.getDescricao());
		return (pstm.executeUpdate() > 0);
	}

	public boolean update(TipoProdutoDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_update);
		pstm.setString(1, dto.getDescricao());
		pstm.setInt(2, dto.getId());
		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public boolean delete(TipoProdutoDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_delete);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public List<TipoProdutoDTO> getAll() throws SQLException {
		try {
			List<TipoProdutoDTO> lista = new ArrayList<TipoProdutoDTO>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql_select);
			while (rs.next()) {
				TipoProdutoDTO dto = new TipoProdutoDTO(rs.getInt("id"), rs.getString("descricao"));
				lista.add(dto);
			}

			return lista;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public TipoProdutoDTO getById(int id) {
		try {
			TipoProdutoDTO dto = null;
			PreparedStatement pstm = conn.prepareStatement(sql_by_id);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			if (rs.first()) {
				dto = new TipoProdutoDTO(rs.getInt("id"), rs.getString("descricao"));

			}

			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static List<TipoProdutoDTO> getListarTipoProdutos() {
		// TODO Auto-generated method stub
		return null;
	}
}
