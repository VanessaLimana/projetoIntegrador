package br.com.salao;

import java.util.List;

import br.com.salao.dao.AtendimentoDAO;
import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.dto.AtendimentoDTO;
import br.com.salao.dto.FuncionarioDTO;

public class MainTest {
	
	public static void main(String[] args) {
		List<FuncionarioDTO> test = new FuncionarioDAO().findAll();
		System.out.println(test);
	}


}
