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

import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.dto.FuncionarioDTO;
import br.com.salao.dto.AtendimentoDTO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.TipoServicoDTO;

@ManagedBean(name="fun")
@ViewScoped
public class FuncionarioBean {

	private FuncionarioDTO funcionarioDto = new FuncionarioDTO();
	private FuncionarioDAO funcionarioDao;
	private DataModel<FuncionarioDTO> funcionarios;
	private FuncionarioDTO functionario;
	private ClienteDTO client;
	private TipoServicoDTO tprod;


	
	//Ao anotar com postconstruct basicamente manda o jsf executar esse metodo apos instanciar esse bean
	@PostConstruct
	public void init() {
		this.funcionarioDao = new FuncionarioDAO();
	}
	 

	public List<FuncionarioDTO> getFuncionariosList() {
		List<FuncionarioDTO> test = this.funcionarioDao.findAll(); 
		System.out.println(test);
		return this.funcionarioDao.findAll();
	}
	
	
	
	public FuncionarioDTO getDto(){
		return this.funcionarioDto;
	}
	//tomcat ta meio bugado...
	public void setDto(FuncionarioDTO dto){
		this.funcionarioDto = dto;
	}
	
	public void sel(){
		funcionarioDto = funcionarios.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		funcionarioDao = new FuncionarioDAO();
		
		if(funcionarioDao.update(funcionarioDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		funcionarioDao = new FuncionarioDAO();
		if(funcionarioDao.delete(funcionarioDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public void insert(){
		funcionarioDto = new FuncionarioDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		funcionarioDao = new FuncionarioDAO();
		
		if(funcionarioDao.insert(funcionarioDto)){
			retorno = "listarFuncionario";
		}
		
		return retorno;
	}
	
	public DataModel<FuncionarioDTO> getFuncionarios() throws SQLException, ClassNotFoundException{
		funcionarioDao = new FuncionarioDAO();
		List<FuncionarioDTO> lista = funcionarioDao.findAll();
		funcionarios = new ListDataModel<FuncionarioDTO>(lista);
		return funcionarios;
	}
	
	public void setFuncionarios(DataModel<FuncionarioDTO> funcionarios){
		this.funcionarios = funcionarios;
	}

	//essa propriedade abaixo vai ter o funcionario selecionado pelo usuario...
	//ai quando ele clicar em insert....é essa propriedade que voce vai salvar no banco..
	
	public FuncionarioDTO getFunctionario() {
		return functionario;
	}

	public void setFunctionario(FuncionarioDTO functionario) {
		System.out.println("Funcionario selecionado..." + functionario.getNome());
		this.functionario = functionario;
	}
	
	public ClienteDTO getClient() {
		return client;
	}

	public void setClient(ClienteDTO client) {
		System.out.println("Cliente selecionado..." + client.getNomecliente());
		this.client = client;
	}

	public TipoServicoDTO getTprod() {
		return tprod;
	}

	public void setTprod(TipoServicoDTO tprod) {
		System.out.println("Serviço selecionado..." + tprod.getDescricaoserv());
		this.tprod = tprod;
	}
	
}
