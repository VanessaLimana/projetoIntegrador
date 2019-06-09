package br.com.salao.dto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TipoServicoDTO {

	private int id;
	private String descricaoserv;
	
	public TipoServicoDTO(ResultSet result) {
		try {
			this.setId(result.getInt("id"));
			this.setDescricaoserv(result.getString("descricaoserv"));		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricaoserv() {
		return descricaoserv;
	}

	public void setDescricaoserv(String descricaoserv) {
		this.descricaoserv = descricaoserv;
	}
	
	public TipoServicoDTO(){}
	
	public TipoServicoDTO(int id, String descricaoserv){
		this.setId(id);
		this.setDescricaoserv(descricaoserv);
	}


}
