package br.com.salao.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.dao.TipoProdutoDAO;

public class AtendimentoDTO {
	private int id;
	private FuncionarioDTO funcionariochave;
	private ClienteDTO clientechave;
	private String tiposervicochave;
	private TipoProdutoDTO produtochave;
	private String dia;
	private String horario;
	private String observacao;	
	
	public AtendimentoDTO(){
	
	}
	
	public AtendimentoDTO(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.clientechave = new ClienteDAO().getById(result.getInt("clientechave"));
			this.funcionariochave = new FuncionarioDAO().getById(result.getInt("funcionariochave"));
			this.dia = result.getString("dia");
			this.horario = result.getString("horario");
			this.observacao = result.getString("observacao");
			this.produtochave = new TipoProdutoDAO().getById(result.getInt("produtochave"));
			this.tiposervicochave = result.getString("tiposervicochave");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public AtendimentoDTO(int id, int idFuncionario, int idCliente, String tipoServicoChave, int idTipoProduto,
			String dia, String horario, String observacao ){
		
		this.setId(id);
		this.funcionariochave = funcionariochave;
		this.clientechave = clientechave;
		this.tiposervicochave = tipoServicoChave;
		this.produtochave = produtochave;
		this.dia = dia; 
		this.horario = horario; 
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

	public String getTiposervicochave() {
		return tiposervicochave;
	}

	public void setTiposervicochave(String tiposervicochave) {
		this.tiposervicochave = tiposervicochave;
	}

	public TipoProdutoDTO getProdutochave() {
		return produtochave;
	}

	public void setProdutochave(TipoProdutoDTO produtochave) {
		this.produtochave = produtochave;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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
	
}
