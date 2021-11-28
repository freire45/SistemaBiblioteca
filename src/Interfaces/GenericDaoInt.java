package Interfaces;

import java.sql.Connection;

public interface GenericDaoInt {

	public Connection getConnection();
	public void fechaConexao();
	
}
