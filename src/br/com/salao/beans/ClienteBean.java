package br.com.salao.beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.ClienteDAO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.ClienteDTO;

@ManagedBean(name="cli")
@SessionScoped
public class ClienteBean {

	private ClienteDTO dto = new ClienteDTO();
	private ClienteDAO dao;
	private DataModel<ClienteDTO> clientes;
	
	public ClienteDTO getDto(){
		return this.dto;
	}
	
	public void setDto(ClienteDTO dto){
		this.dto = dto;
	}
	
	public void sel(){
		dto = clientes.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new ClienteDAO();
		
		if(dao.update(dto)){
			retorno = "listarCliente";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new ClienteDAO();
		if(dao.delete(dto)){
			retorno = "listarCliente";
		}
		
		return retorno;
	}
	
	public void insert(){
		dto = new ClienteDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		dao = new ClienteDAO();
		
		if(dao.insert(dto)){
			retorno = "listarCliente";
		}
		
		return retorno;
	}
	
	public DataModel<ClienteDTO> getClientes() throws SQLException, ClassNotFoundException{
		dao = new ClienteDAO();
		List<ClienteDTO> lista = dao.getAll();
		clientes = new ListDataModel<ClienteDTO>(lista);
		return clientes;
	}
	
	public void setClientes(DataModel<ClienteDTO> clientes){
		this.clientes = clientes;
	}
}

