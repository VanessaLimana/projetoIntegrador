package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.ClienteDTO;

public class ClienteDAO {

	private static final String tbl_name = "clientes";
	private static final String sql_insert = "INSERT INTO " 
			+ tbl_name + " (nomecliente, email, cpf, sexo,telefone, status) VALUES (?, ?, ?, ?, ?,?)";
	private static final String sql_update = "UPDATE clientes SET nomecliente = ?, email = ?, cpf = ?, sexo = ? telefone = ? status =? WHERE id = ?";
	private static final String sql_update2 = "UPDATE clientes SET status = inativo WHERE id = ?";
	private static final String sql_select = "SELECT * FROM clientes";
	private static final String sql_by_id = "SELECT * FROM clientes WHERE id = ?";
	private Connection conn = null;
	
	public ClienteDAO() {
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * * (nome, email, cpf, sexo,telefone, status)
	 */
	public boolean insert(ClienteDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_insert);
		pstm.setString(1, dto.getNomecliente());
		pstm.setString(2, dto.getEmail());
		pstm.setString(3, dto.getCpf());
		pstm.setString(4, dto.getSexo());
		pstm.setString(5, dto.getTelefone());
		pstm.setString(7, dto.getStatus());
		return (pstm.executeUpdate() > 0);
	}

	/*
	 * * * (nome, email, cpf, sexo,telefone, status)
	 */
	public boolean update(ClienteDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_update);
		pstm.setString(1, dto.getNomecliente());
		pstm.setString(2, dto.getEmail());
		pstm.setString(3, dto.getCpf());
		pstm.setString(4, dto.getSexo());
		pstm.setString(5, dto.getTelefone());
		pstm.setString(6, dto.getStatus());
		pstm.setInt(7, dto.getId());
		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public boolean delete(ClienteDTO dto) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sql_update2);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}

	public List<ClienteDTO> getAll() throws SQLException {
		try {
			List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql_select);
			while (rs.next()) {
				
				
				ClienteDTO dto = new ClienteDTO(rs.getInt("id"), rs.getString("nomecliente"), rs.getString("email"),
						rs.getString("cpf"), rs.getString("sexo"), rs.getString("telefone"), rs.getString("status"));
				lista.add(dto);
			}
			/*
			 * (nome, email, cpf, sexo,telefone, status)
			 */			return lista;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ClienteDTO getById(int id) {
		try {
			ClienteDTO dto = null;
			PreparedStatement pstm = conn.prepareStatement(sql_by_id);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			if (rs.first()) {
				dto = new ClienteDTO(rs.getInt("id"), rs.getString("nomecliente"), rs.getString("email"),
						rs.getString("cpf"), rs.getString("sexo"), rs.getString("telefone"), rs.getString("status"));

			}

			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static List<ClienteDTO> getListarClientes() {
		// TODO Auto-generated method stub
		return null;
	}
}