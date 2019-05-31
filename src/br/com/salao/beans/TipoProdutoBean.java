package br.com.salao.beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.dao.TipoProdutoDAO;
import br.com.salao.dto.TipoProdutoDTO;

@ManagedBean(name="tp")
@SessionScoped
public class TipoProdutoBean {

	private TipoProdutoDTO dto = new TipoProdutoDTO();
	private TipoProdutoDAO dao;
	private DataModel<TipoProdutoDTO> tipoProdutos;
	
	public TipoProdutoDTO getDto(){
		return this.dto;
	}
	
	public void setDto(TipoProdutoDTO dto){
		this.dto = dto;
	}
	
	public void sel(){
		dto = tipoProdutos.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new TipoProdutoDAO();
		
		if(dao.update(dto)){
			retorno = "listarTipoProduto";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new TipoProdutoDAO();
		if(dao.delete(dto)){
			retorno = "listarTipoProduto";
		}
		
		return retorno;
	}
	
	public void insert(){
		dto = new TipoProdutoDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new TipoProdutoDAO();
		
		if(dao.insert(dto)){
			retorno = "listarTipoProduto";
		}
		
		return retorno;
	}
	
	public DataModel<TipoProdutoDTO> getTipoProdutos() throws SQLException, ClassNotFoundException{
		dao = new TipoProdutoDAO();
		List<TipoProdutoDTO> lista = dao.getAll();
		tipoProdutos = new ListDataModel<TipoProdutoDTO>(lista);
		return tipoProdutos;
	}
	
	public void setTipoProdutos(DataModel<TipoProdutoDTO> tipoProdutos){
		this.tipoProdutos = tipoProdutos;
	}
}
