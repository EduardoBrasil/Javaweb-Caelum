package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Contato contato = new Contato();
		
		//inserindo os dados
		contato.setNome("Marcddddddddddo");
		contato.setEmail("Veio@contato.com.br");
		contato.setEndereco("Rua vascoas");
		contato.setId(1);
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.altera(contato);
		System.out.println("Contato Alterado com sucesso");
	}

}
