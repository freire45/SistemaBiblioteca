package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Interfaces.GenericDaoInt;

public class GenericDAOImpl implements GenericDaoInt {

	private static Connection con;

	public Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "123456");
			System.out.println("Conexao ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void fechaConexao() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}