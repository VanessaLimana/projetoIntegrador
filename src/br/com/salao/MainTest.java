package br.com.salao;

import java.util.List;

import br.com.salao.dao.AtendimentoDAO;
import br.com.salao.dto.AtendimentoDTO;

public class MainTest {
	
	public static void main(String[] args) {
		List<AtendimentoDTO> test = new AtendimentoDAO().getAll();
		System.out.println(test);
	}


}
