package Interfaces;

import java.sql.SQLException;
import java.util.List;

import Biblioteca.Emprestimo;

public interface EmprestimoDAO {
	
	public void adicionarEmprestimo(Emprestimo e) throws SQLException;

	public List<Emprestimo> pesquisaBairro() throws SQLException;
	
	public void remover(Emprestimo em) throws SQLException;

}
