package Interfaces;

import java.sql.SQLException;
import java.util.List;

import Biblioteca.Devolucao;

public interface DevolucaoDAO {
	
	public void adicionarBairro(Devolucao e) throws SQLException;

	public List<Devolucao> pesquisaBairro() throws SQLException;
	
	public void remover(Devolucao d) throws SQLException;
	
	

}
