package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dto.ClienteDTO;


public class ClienteDAO {

	private static final String tbl_name = "clientes"; 
	private static final String sql_insert = "INSERT INTO " 
			+ tbl_name + " (clientechave, clientechave, tiposervicochave, produtochave, dia, horario, observacao ) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String sql_update = "UPDATE clientes SET clientechave = ?, clientechave = ?, tiposervicochave = ?, produtochave = ? dia = ? horario = ? observacao = ? WHERE id = ?";
	private static final String sql_delete = "DELETE FROM clientes WHERE id = ?";
	private static final String sql_select = "SELECT * FROM clientes";
	private static final String sql_by_id = "SELECT * FROM clientes WHERE id = ?";
	
	private Connection conn = null;
	private Object connection;
	
	public ClienteDAO() {		
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ClienteDTO> findAll() {
		String sql = "SELECT * FROM clientes ";
		
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				clientes.add(new ClienteDTO(result));
			}

		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return clientes;
	}
	
	public ClienteDTO findById(int id) {
		String sql = "SELECT * FROM clientes WHERE id = ?";

		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			ClienteDTO clienteDTO = new ClienteDTO(result);
			
			return clienteDTO;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	/*
	 * public ClienteDTO(int id, String nome, String endereco, String email,
	 * String cpf, String sexo, String senha,String telefone, String cargo){
	 */
	public boolean insert(ClienteDTO dto) throws SQLException{
		// o banco
		PreparedStatement pstm = conn.prepareStatement(sql_insert);	
		pstm.setString(1, dto.getNomecliente());
		pstm.setString(2, dto.getEmail());
		pstm.setString(3, dto.getCpf());
		pstm.setString(4, dto.getSexo());
		pstm.setString(5, dto.getTelefone());
		pstm.setString(7, dto.getStatus());
		return (pstm.executeUpdate() > 0);

	}
	public boolean update(ClienteDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_update);

		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public boolean delete(ClienteDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_delete);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
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
