package br.com.salao.dto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class FuncionarioDTO {

	private int id;
	private String nome;
	private String endereco;
	private String cpf;
	private String telefone;
	private String sexo;
	private String cargo;
	private String email;
	private String senha; 
	
	public FuncionarioDTO(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.nome = result.getString("nome");
			this.endereco = result.getString("endereco");
			this.cpf = result.getString("cpf");
			this.telefone = result.getString("telefone");
			this.sexo = result.getString("sexo");
			this.cargo = result.getString("cargo");
			this.email = result.getString("email");
			this.senha = result.getString("senha");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * nome, endereco, cpf, telefone, sexo, cargo, email, senha
	 */	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public FuncionarioDTO(){}
	
	public FuncionarioDTO(int id, String nome, String endereco, String email, String cpf, String sexo, String senha,String telefone, String cargo){
		this.id = id;
		this.setNome(nome);
		this.setEmail(email);
		this.setCpf(cpf);
		this.setSexo(sexo); 
		this.setSenha(senha);
		this.setCargo(cargo);
		this.setTelefone(telefone);

	}

	
}
