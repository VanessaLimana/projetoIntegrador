package br.com.salao.beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.dao.TipoServicoDAO;
import br.com.salao.dto.TipoServicoDTO;

@ManagedBean(name="tiposerv")
@SessionScoped
public class TipoServicoBean {

	private TipoServicoDTO dto = new TipoServicoDTO();
	private TipoServicoDAO dao;
	private DataModel<TipoServicoDTO> tipoServicos;
	
	public TipoServicoDTO getDto(){
		return this.dto;
	}
	
	public void setDto(TipoServicoDTO dto){
		this.dto = dto;
	}
	
	public void sel(){
		dto = tipoServicos.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new TipoServicoDAO();
		
		if(dao.update(dto)){
			retorno = "listarTipoServico";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new TipoServicoDAO();
		if(dao.delete(dto)){
			retorno = "listarTipoServico";
		}
		
		return retorno;
	}
	
	public void insert(){
		dto = new TipoServicoDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new TipoServicoDAO();
		
		if(dao.insert(dto)){
			retorno = "listarTipoServico";
		}
		
		return retorno;
	}
	
	public DataModel<TipoServicoDTO> getTipoServicos() throws SQLException, ClassNotFoundException{
		dao = new TipoServicoDAO();
		List<TipoServicoDTO> lista = dao.getAll();
		tipoServicos = new ListDataModel<TipoServicoDTO>(lista);
		return tipoServicos;
	}
	
	public void setTipoServicos(DataModel<TipoServicoDTO> tipoServicos){
		this.tipoServicos = tipoServicos;
	}
}
