package br.com.salao.beans;



import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.salao.dao.ClienteDAO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.AtendimentoDTO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.TipoServicoDTO;

@ManagedBean(name="cli")
@ViewScoped
public class ClienteBean {

	private ClienteDTO clienteDto = new ClienteDTO();
	private ClienteDAO clienteDao;
	private DataModel<ClienteDTO> clientes;
	private ClienteDTO client;
	

	@PostConstruct
	public void init() {
		this.clienteDao = new ClienteDAO();
	}
	 

	public List<ClienteDTO> getClientesList() {
		List<ClienteDTO> test = this.clienteDao.findAll(); 
		System.out.println(test);
		return this.clienteDao.findAll();
	}
	
	
	
	public ClienteDTO getDto(){
		return this.clienteDto;
	}

	public void setDto(ClienteDTO dto){
		this.clienteDto = dto;
	}
	
	public void sel(){
		clienteDto = clientes.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		clienteDao = new ClienteDAO();
		
		if(clienteDao.update(clienteDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		clienteDao = new ClienteDAO();
		if(clienteDao.delete(clienteDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public void insert(){
		clienteDto = new ClienteDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		clienteDao = new ClienteDAO();
		
		if(clienteDao.insert(clienteDto)){
			retorno = "listarClientes";
		}
		
		return retorno;
	}
	
	public DataModel<ClienteDTO> getClientes() throws SQLException, ClassNotFoundException{
		clienteDao = new ClienteDAO();
		List<ClienteDTO> lista = clienteDao.findAll();
		clientes = new ListDataModel<ClienteDTO>(lista);
		return clientes;
	}
	
	public void setClientes(DataModel<ClienteDTO> clientes){
		this.clientes = clientes;
	}

	
	public ClienteDTO getFunctionario() {
		return client;
	}

	public void setFunctionario(ClienteDTO client) {
		System.out.println("Cliente selecionado..." + client.getNomecliente());
		this.client = client;
	}

}
