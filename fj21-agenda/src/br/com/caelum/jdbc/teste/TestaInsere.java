package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//criando objeto Contato
		Contato contato = new Contato();
		
		//inserindo os dados
		contato.setNome("TesteBanco");
		contato.setEmail("caelum@contato.com.br");
		contato.setEndereco("R. Vergueiro 2185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//grave essa conexão!!
		ContatoDao dao = new ContatoDao(); 
		
		//método elegante
		dao.adiciona(contato);
		
		System.out.println("Contato guardado");
	}
}
