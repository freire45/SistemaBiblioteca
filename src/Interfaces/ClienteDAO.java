package Interfaces;

import java.sql.SQLException;
import java.util.List;

import Biblioteca.Cliente;

public interface ClienteDAO {
	
	public void adicionarCliente(Cliente c) throws SQLException;

	public List<Cliente> pesquisaCliente() throws SQLException;
	
	public void remover(Cliente c) throws SQLException;
	
	public void atualizarCliente(Cliente c) throws SQLException;


}
