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

import br.com.salao.dao.AtendimentoDAO;
import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.dto.AtendimentoDTO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.FuncionarioDTO;
import br.com.salao.dto.TipoServicoDTO;

@ManagedBean(name="ate")
@ViewScoped
public class AtendimentoBean {

	private AtendimentoDTO atendimentoDto = new AtendimentoDTO();
	private AtendimentoDAO atendimentoDao;
	private DataModel<AtendimentoDTO> atendimentos;
	private FuncionarioDTO functionario;
	private ClienteDTO client;
	private TipoServicoDTO tprod;
	private FuncionarioDAO funcionarioDao;


	
	//Ao anotar com postconstruct basicamente manda o jsf executar esse metodo apos instanciar esse bean
	@PostConstruct
	public void init() {
		this.atendimentoDao = new AtendimentoDAO();
		this.funcionarioDao = new FuncionarioDAO();
	}

	public List<FuncionarioDTO> getFuncionariosList() {
		List<FuncionarioDTO> test = this.funcionarioDao.findAll(); 
		System.out.println(test);
		return this.funcionarioDao.findAll();
	}
	
	public List<AtendimentoDTO> getAtendimentosList() {
		return this.atendimentoDao.getAll();
	}
	
	
	public AtendimentoDTO getDto(){
		return this.atendimentoDto;
	}
	//tomcat ta meio bugado...
	public void setDto(AtendimentoDTO dto){
		this.atendimentoDto = dto;
	}
	
	public void sel(){
		atendimentoDto = atendimentos.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		atendimentoDao = new AtendimentoDAO();
		
		if(atendimentoDao.update(atendimentoDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		atendimentoDao = new AtendimentoDAO();
		if(atendimentoDao.delete(atendimentoDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public void insert(){
		atendimentoDto = new AtendimentoDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		atendimentoDao = new AtendimentoDAO();
		
		if(atendimentoDao.insert(atendimentoDto)){
			retorno = "listarAtendimento";
		}
		
		return retorno;
	}
	
	public DataModel<AtendimentoDTO> getAtendimentos() throws SQLException, ClassNotFoundException{
		atendimentoDao = new AtendimentoDAO();
		List<AtendimentoDTO> lista = atendimentoDao.getAll();
		atendimentos = new ListDataModel<AtendimentoDTO>(lista);
		return atendimentos;
	}
	
	public void setAtendimentos(DataModel<AtendimentoDTO> atendimentos){
		this.atendimentos = atendimentos;
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
