package br.com.salao.dto;

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
		this.setTelefone(telefone);
		this.setSexo(sexo); 
		this.setSenha(senha);
		this.setCargo(cargo);
	}
	
	
}
