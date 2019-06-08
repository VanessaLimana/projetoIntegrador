package br.com.salao.dto;

public class TipoServicoDTO {

	private int id;
	private String descricaoserv;
	
	/*
	 * nome, endereco, cpf, telefone, sexo, cargo, email, senha
	 */	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public TipoServicoDTO(){}
	
	public TipoServicoDTO(int id, String descricaoserv){
		this.id = id;
		this.setDescricaoserv(descricaoserv);
	}

	public String getDescricaoserv() {
		return descricaoserv;
	}

	public void setDescricaoserv(String descricaoserv) {
		this.descricaoserv = descricaoserv;
	}
	
	
}
