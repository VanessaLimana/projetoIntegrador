package br.com.salao.dto;

public class TipoProdutoDTO {

	private int id;
	private String descricao;
	
	/*
	 * nome, endereco, cpf, telefone, sexo, cargo, email, senha
	 */	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public TipoProdutoDTO(){}
	
	public TipoProdutoDTO(int id, String descricao){
		this.id = id;
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
