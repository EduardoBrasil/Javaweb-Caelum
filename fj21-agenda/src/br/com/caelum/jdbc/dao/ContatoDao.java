package br.com.caelum.jdbc.dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

//Classe para gerenciar a conexão e inserir Contatos no banco de dados.

public class ContatoDao {	
	
	// conexão com o banco de dados
	private Connection connection;
	
	//a conexao recebe Connection e pega a conexão criada pela Fabrica de conexão
	public ContatoDao() throws ClassNotFoundException {
		this.connection = (Connection) new ConnectionFactory().getConnection();		
	}
	
	
	//método Adicionar 
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" +
				     "values (?,?,?,?)";
		try {
			//prepared Statement para inserção passando SQL como parametro
			PreparedStatement stmt = 
					connection.prepareStatement(sql);
			
			//setando valores no banco
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
	
			//executa a ação no banco
			stmt.execute();
			stmt.close();
			
		} catch(SQLException e ) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() throws SQLException{
		
		try {	
			
			//pega a conexão e o statement
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contatos");
			
			//executa o select (ResultSet permite navegar nos registros com o executeQuery)
			ResultSet rs = stmt.executeQuery();
	
			List<Contato> contatos = new ArrayList<Contato>();		
			//Itera sobre o rs
			while(rs.next()) {
				//criando objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//Montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);       
				           
				//adicionando objeto a lista
				 contatos.add(contato);	
			}
			
			rs.close();
			stmt.close();
			return contatos;
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public Contato getCotato(Contato contato) throws SQLException {
		String sql = "select * from contatos where id = ?";
		Contato contatoSelecionado = new Contato();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				contatoSelecionado.setId(rs.getLong("id"));
				contatoSelecionado.setNome(rs.getString("nome"));
				contatoSelecionado.setEmail(rs.getString("email"));
				contatoSelecionado.setEndereco(rs.getString("endereco"));
				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contatoSelecionado.setDataNascimento(data);
			}			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return contatoSelecionado;
	}
	
	public void altera(Contato contato) {
			String sql = "update contatos set nome=?, email=?, endereco=?,"
					+ "dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			//fechando a conexao
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from * contato wherer id =?");
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException ();
		}
	}
}
	