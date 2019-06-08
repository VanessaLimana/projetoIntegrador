package br.com.salao.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.dao.TipoServicoDAO;

public class AtendimentoDTO {
	private int id;
	private FuncionarioDTO funcionariochave;
	private ClienteDTO clientechave;
	private TipoServicoDTO tiposervicochave;
	private String dia;
	private String horarioinicial;
	private String horariofinal;
	private String observacao;	
	
	public AtendimentoDTO(){
	
	}
	
	public AtendimentoDTO(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.clientechave = new ClienteDAO().getById(result.getInt("clientechave"));
			this.funcionariochave = new FuncionarioDAO().getById(result.getInt("funcionariochave"));
			this.tiposervicochave = new TipoServicoDAO().getById(result.getInt("tiposervicochave"));
			this.dia = result.getString("dia");
			this.horarioinicial = result.getString("horarioinicial");
			this.horariofinal = result.getString("horariofinal");

			this.observacao = result.getString("observacao");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public AtendimentoDTO(int id, int idFuncionario, int idCliente, int idTipoServico, String dia, String horarioinicial, String horariofinal , String observacao ){
		
		this.setId(id);
		this.funcionariochave = funcionariochave;
		this.clientechave = clientechave;
		this.tiposervicochave = tiposervicochave;
		this.dia = dia; 
		this.horarioinicial = horarioinicial;
		this.setHorariofinal(horariofinal); 
		this.observacao = observacao; 

	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FuncionarioDTO getFuncionariochave() {
		return funcionariochave;
	}

	public void setFuncionariochave(FuncionarioDTO funcionariochave) {
		this.funcionariochave = funcionariochave;
	}

	public ClienteDTO getClientechave() {
		return clientechave;
	}

	public void setClientechave(ClienteDTO clientechave) {
		this.clientechave = clientechave;
	}

	public TipoServicoDTO getServicochave() {
		return tiposervicochave;
	}

	public void setServicochave(TipoServicoDTO tiposervicochave) {
		this.tiposervicochave = tiposervicochave;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorarioinicial() {
		return horarioinicial;
	}

	public void setHorario(String horariofinal) {
		this.setHorariofinal(horariofinal);
	}
	
	
	
	/*
	 * id, funcionariochave, clientechave, tiposervicochave, produtochave, dia, horario,
	 * observacao
	 */	
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getHorariofinal() {
		return horariofinal;
	}

	public void setHorariofinal(String horariofinal) {
		this.horariofinal = horariofinal;
	}
	
}
