package br.com.salao.beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.dto.FuncionarioDTO;

@ManagedBean(name="fun")
@SessionScoped
public class FuncionarioBean {

	private FuncionarioDTO dto = new FuncionarioDTO();
	private FuncionarioDAO dao;
	private DataModel<FuncionarioDTO> funcionarios;
	
	public FuncionarioDTO getDto(){
		return this.dto;
	}
	
	public void setDto(FuncionarioDTO dto){
		this.dto = dto;
	}
	
	public void sel(){
		dto = funcionarios.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new FuncionarioDAO();
		
		if(dao.update(dto)){
			retorno = "listarFuncionario";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new FuncionarioDAO();
		if(dao.delete(dto)){
			retorno = "listarFuncionario";
		}
		
		return retorno;
	}
	
	public void insert(){
		dto = new FuncionarioDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new FuncionarioDAO();
		
		if(dao.insert(dto)){
			retorno = "listarFuncionario";
		}
		
		return retorno;
	}
	
	public DataModel<FuncionarioDTO> getFuncionarios() throws SQLException, ClassNotFoundException{
		dao = new FuncionarioDAO();
		List<FuncionarioDTO> lista = dao.getAll();
		funcionarios = new ListDataModel<FuncionarioDTO>(lista);
		return funcionarios;
	}
	
	public void setFuncionarios(DataModel<FuncionarioDTO> funcionarios){
		this.funcionarios = funcionarios;
	}
}
