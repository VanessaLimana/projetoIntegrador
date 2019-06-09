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

import br.com.salao.dao.TipoServicoDAO;
import br.com.salao.dto.TipoServicoDTO;
import br.com.salao.dto.AtendimentoDTO;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.TipoServicoDTO;

@ManagedBean(name="tp")
@ViewScoped
public class TipoServicoBean {

	private TipoServicoDTO tipoServicoDto = new TipoServicoDTO();
	private TipoServicoDAO tipoServicoDao;
	private DataModel<TipoServicoDTO> tipoServicos;
	private TipoServicoDTO tprod;
	

	@PostConstruct
	public void init() {
		this.tipoServicoDao = new TipoServicoDAO();
	}
	 

	public List<TipoServicoDTO> getTipoServicosList() {
		List<TipoServicoDTO> test = this.tipoServicoDao.findAll(); 
		System.out.println(test);
		return this.tipoServicoDao.findAll();
	}
	
	
	
	public TipoServicoDTO getDto(){
		return this.tipoServicoDto;
	}
	//tomcat ta meio bugado...
	public void setDto(TipoServicoDTO dto){
		this.tipoServicoDto = dto;
	}
	
	public void sel(){
		tipoServicoDto = tipoServicos.getRowData();
	}
	
	public String update() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		tipoServicoDao = new TipoServicoDAO();
		
		if(tipoServicoDao.update(tipoServicoDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public String apagar() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		tipoServicoDao = new TipoServicoDAO();
		if(tipoServicoDao.delete(tipoServicoDto)){
			retorno = "listar";
		}
		
		return retorno;
	}
	
	public void insert(){
		tipoServicoDto = new TipoServicoDTO();
	}
	
	public String save() throws SQLException, ClassNotFoundException{
		String retorno = "erro";
		
		tipoServicoDao = new TipoServicoDAO();
		
		if(tipoServicoDao.insert(tipoServicoDto)){
			retorno = "listarTipoServico";
		}
		
		return retorno;
	}
	
	public DataModel<TipoServicoDTO> getTipoServicos() throws SQLException, ClassNotFoundException{
		tipoServicoDao = new TipoServicoDAO();
		List<TipoServicoDTO> lista = tipoServicoDao.findAll();
		tipoServicos = new ListDataModel<TipoServicoDTO>(lista);
		return tipoServicos;
	}
	
	public void setTipoServicos(DataModel<TipoServicoDTO> tipoServicos){
		this.tipoServicos = tipoServicos;
	}

	
	public TipoServicoDTO getTprod() {
		return tprod;
	}

	public void setTipoServico(TipoServicoDTO tprod) {
		System.out.println("Tipo Servico selecionado..." + tprod.getDescricaoserv());
		this.tprod = tprod;
	}

}
