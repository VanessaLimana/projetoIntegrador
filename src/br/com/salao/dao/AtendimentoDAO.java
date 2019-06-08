package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dto.AtendimentoDTO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.FuncionarioDTO;


public class AtendimentoDAO {

	private static final String tbl_name = "atendimentos";//aqui 
	private static final String sql_insert = "INSERT INTO " 
			+ tbl_name + " (funcionariochave, clientechave, tiposervicochave, produtochave, dia, horario, observacao ) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String sql_update = "UPDATE atendimentos SET funcionariochave = ?, clientechave = ?, tiposervicochave = ?, produtochave = ? dia = ? horario = ? observacao = ? WHERE id = ?";
	private static final String sql_delete = "DELETE FROM atendimentos WHERE id = ?";
	private static final String sql_select = "SELECT * FROM atendimentos";
	private static final String sql_by_id = "SELECT * FROM atendimentos WHERE id = ?";
	
	private Connection conn = null;
	private Object connection;
	
	public AtendimentoDAO() {		
		try {
			DB db = new DB();
			conn = db.getConn();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//vamos antes precisar testar se os dados estao vindo do banco...voce ja conseguiu trazer
		//algo do banco?
		//sim boa das outras tabelas, tem cadastro, e lista mas nessa ainda nao funciona
	}
	/*
	 * id, funcionariochave, clientechave, tiposervicochave, produtochave, dia, horario,
	 * observacao
	 */	
	
	/*
	 * public List<FuncionarioDTO> getBuscarFuncionarios() {
	 * 
	 * try { List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
	 * PreparedStatement stmt = ((Connection) this.connection)
	 * .prepareStatement("select p.nome, p.id from funcionarios f " +
	 * "inner join atendimentos p on p.id=f.id");
	 * 
	 * ResultSet rs = stmt.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
	 * 
	 * funcionarioDTO.setNome(rs.getString("nome"));
	 * funcionarioDTO.setId(rs.getInt("id"));
	 * 
	 * funcionarios.add(funcionarioDTO); }
	 */
	/*
	 * rs.close(); stmt.close();
	 * System.out.println("Fechando a conexão com o banco"); return funcionarios; }
	 * catch (SQLException e) { throw new RuntimeException(e); } }
	 */
	
/*	public class ControleFuncionario {
		FuncionarioDTO funcionarioDto = new FuncionarioDTO();
		FuncionarioDTO cidadeDAO = new FuncionarioDTO();

		public List<FuncionarioDTO> getFuncionarios() throws SQLException{
		    List<FuncionarioDTO> funcionarios = FuncionarioDAO.getListarFuncionarios();
		    return funcionarios;
		}
	*/
	
	/*
	 * public boolean insert(AtendimentoDTO dto) throws SQLException{ //aqui acho q
	 * ta errado //entao, voce ja fez a view onde o usuario vai adicionar os
	 * valores? //aqu chamaria as estrangeiras para inserir ... eu acho n sei
	 * 
	 * //o projeto ja roda? pra eu ver
	 * 
	 * //sim, so vou arrumar pera ae ta PreparedStatement pstm =
	 * conn.prepareStatement(sql_insert); pstm.setInt(1,
	 * dto.getFuncionariochave().getId()); pstm.setInt(2,
	 * dto.getClientechave().getId()); pstm.setString(3, dto.getTiposervicochave());
	 * pstm.setString(4, dto.getProdutochave()); pstm.setString(5, dto.getDia());
	 * pstm.setString(6, dto.getHorario()); pstm.setString(7, dto.getObservacao());
	 * 
	 * return (pstm.executeUpdate() > 0); }
	 */
	
	public AtendimentoDTO findById(int id) {
		String sql = "SELECT * FROM atendimentos WHERE id = ?";

		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			AtendimentoDTO atendimentoDTO = new AtendimentoDTO(result);
			
			return atendimentoDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public boolean insert(AtendimentoDTO dto) throws SQLException{
		// o banco
		PreparedStatement pstm = conn.prepareStatement(sql_insert);
		pstm.setInt(1, dto.getFuncionariochave().getId());
		pstm.setInt(2, dto.getClientechave().getId());
		pstm.setInt(3, dto.getServicochave().getId());
		pstm.setString(4, dto.getDia());
		pstm.setString(5, dto.getHorarioinicial());
		pstm.setString(6, dto.getHorariofinal());
		pstm.setString(7, dto.getObservacao());

		return (pstm.executeUpdate() > 0);
	}
	public boolean update(AtendimentoDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_update);
		pstm.setInt(1, dto.getFuncionariochave().getId());
		pstm.setInt(2, dto.getClientechave().getId());
		pstm.setInt(3, dto.getServicochave().getId());
		pstm.setString(4, dto.getDia());
		pstm.setString(5, dto.getHorarioinicial());
		pstm.setString(6, dto.getHorariofinal());
		pstm.setString(7, dto.getObservacao());
		pstm.setInt(8, dto.getId());
		System.out.println(dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public boolean delete(AtendimentoDTO dto) throws SQLException{
		PreparedStatement pstm = conn.prepareStatement(sql_delete);
		pstm.setInt(1, dto.getId());
		return (pstm.executeUpdate() > 0);
	}
	
	public List<AtendimentoDTO> getAll() {
		try {
			List<AtendimentoDTO> lista = new ArrayList<AtendimentoDTO>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql_select);
			
			//o resultset nunca vai retornar um objeto funcionario, ele apenas retorna o id dele....não funciona como o hibernate
			//sempre que usar um get do resultset, pense que ele sempre vai retornar um primitivo, nunca um objeto, ainda mais customizado 
		    //que é o caso do funcionario
			
			while(rs.next()){
				AtendimentoDTO dto = new AtendimentoDTO(rs);			
				lista.add(dto);
			}			
			
	
			/*
			 * id, funcionariochave, clientechave, tiposervicochave, produtochave, dia, horario,
			 * observacao
			 */	
			return lista;
		} catch(SQLException ex) {
			
			ex.printStackTrace();
			return null;
		}
	}
}
