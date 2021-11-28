package Interfaces;

import java.sql.SQLException;
import java.util.List;

import Biblioteca.Livro;

public interface LivroDAO  {
	public boolean adicionarLivro(Livro l) throws SQLException;

	public List<Livro> pesquisaLivro() throws SQLException;
	
	public boolean remover(Livro l) throws SQLException;
	
	public boolean atualizarLivro(Livro l) throws SQLException;
}
