package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Criando um contato na DAO
		ContatoDao dao = new ContatoDao();
		
		//Listando contatos que estão sendo acessados através da dao.getLista da classe ContatoDao
		List<Contato> contatos = dao.getLista();

		//Criando iteração na lista e imprimindo as informações
		for (Contato contato :contatos) {
			System.out.println("Nome " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço " + contato.getEndereco());
			System.out.println("Data de Nascimento" + contato.getDataNascimento().getTime()
			.getTime() + "\n");
		}
	}

}
