package br.com.salao.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDTO {

	private int id;
	private String nomecliente;
	private String email;
	private String cpf;
	private String telefone;
	private String sexo;
	private String status;

	public ClienteDTO(ResultSet result) {
		
		try {
			this.id = result.getInt("id");
			this.nomecliente = result.getString("nomecliente");
			this.email = result.getString("email");
			this.cpf = result.getString("cpf");
			this.telefone = result.getString("telefone");
			this.sexo = result.getString("sexo");
			this.status = result.getString("status");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public int getId() {
		return id;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public ClienteDTO(){}
	
	public ClienteDTO(int id, String nomecliente, String email, String cpf, String sexo,String telefone, String status){
		this.id = id;
		this.nomecliente = nomecliente;
		this.email = email;
		this.cpf = cpf;
		this.telefone =telefone;
		this.sexo = sexo; 
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
