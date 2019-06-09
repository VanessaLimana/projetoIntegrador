package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dto.FuncionarioDTO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.FuncionarioDTO;


public class FuncionarioDAO {

	private static final String tbl_name = "funcionarios"; 
	private static final String sql_insert = "INSERT INTO " 
			+ tbl_name + " (nome, endereco, cpf, telefone, sexo, cargo, email, senha) VALUES (?,?,?,?,?,?,?,?)";
	private static final String sql_update = "UPDATE funcionarios SET nome = ?, endereco = ?, cpf = ?, telefone = ?, sexo = ?, cargo = ?, email = ?, senha = ? WHERE id = ?";
	private static final String sql_delete = "DELETE FROM funcionarios WHERE id = ?";
	private static final String sql_select = "SELECT * FROM funcionarios";
	private static final String sql_by_id = "SELECT * FROM funcionarios WHERE id = ?";
	
	private Connection conn = null;
	private Object connection;
	
	public FuncionarioDAO() {		
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<FuncionarioDTO> findAll() {
		String sql = "SELECT * FROM funcionarios ";
		
		List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				funcionarios.add(new FuncionarioDTO(result));
			}

		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return funcionarios;
	}
	
	public FuncionarioDTO findById(int id) {
		String sql = "SELECT * FROM funcionarios WHERE id = ?";

		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO(result);
			
			return funcionarioDTO;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	/*
	 * public FuncionarioDTO(int id, String nome, String endereco, String email,
	 * String cpf, String sexo, String senha,String telefone, String cargo){
	 */
	public boolean insert(FuncionarioDTO dto) throws SQLException{
		// o banco
		PreparedStatement pstm = conn.prepareStatement(sql_insert);
		pstm.setString(1, dto.getNome());
		pstm.setString(2, dto.getEndereco());
		pstm.setString(3, dto.getEmail());
		pstm.setString(4, dto.getCpf());
		pstm.setString(5, dto.getSexo());
		pstm.setString(6, dto.getSenha());
		pstm.setString(7, dto.getTelefone());
		pstm.setString(8, dto.getCargo());

		return (pstm.executeUpdate() > 0);
	}
	public boolean update(FuncionarioDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_update);

		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public boolean delete(FuncionarioDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_delete);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public FuncionarioDTO getById(int id) {
		try {
			FuncionarioDTO dto = null;
			PreparedStatement pstm = conn.prepareStatement(sql_by_id);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			if (rs.first()) {
				dto = new FuncionarioDTO(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"),
						rs.getString("cpf"), rs.getString("telefone"), rs.getString("sexo"), rs.getString("cargo"),
						rs.getString("email"), rs.getString("senha"));

			}

			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static List<FuncionarioDTO> getListarFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
