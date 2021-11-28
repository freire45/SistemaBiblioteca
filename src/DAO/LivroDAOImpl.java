package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Livro;
import Interfaces.LivroDAO;

public class LivroDAOImpl implements LivroDAO, java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;

	
	public LivroDAOImpl(){
			GenericDAOImpl gDAO = new GenericDAOImpl();
			con = gDAO.getConnection();
	}

	@Override
	public boolean adicionarLivro(Livro e) throws SQLException {
		String sql = ("{call insereLivro(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getCodLivro());
			ps.setString(2, e.getIsbn());
			ps.setString(3, e.getNomeLivro());
			ps.setString(4, e.getDataPub());
			ps.setString(5, e.getNomeAutor());
			ps.setString(6, e.getNomeEditora());
			ps.setString(7, e.getAssunto());
			ps.setString(8, e.getStatus());
			ps.setString(9, e.getDescricao());
			
			ps.execute();
			ps.close();
	
			if(ps.executeUpdate()>0){
				return true;
			} else{
				return false;
			}


	} 
	
	@Override
	public List<Livro> pesquisaLivro() throws SQLException {
		ArrayList<Livro> listaLivro = new ArrayList<Livro>();

		try
		{
		String sql = ("SELECT * FROM livro ORDER BY codLivro ASC");
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Livro a = new Livro();
			a.setCodLivro(rs.getInt("codLivro"));
			a.setNomeLivro(rs.getString("nomeLivro"));
			a.setIsbn(rs.getString("isbn"));
			a.setDataPub(rs.getString("dataPub"));
			a.setNomeAutor(rs.getString("nomeAutor"));
			a.setNomeEditora(rs.getString("nomeEditora"));
			a.setAssunto(rs.getString("assunto"));
			a.setStatus(rs.getString("status"));
			a.setDescricao(rs.getString("descricao"));
			listaLivro.add(a);
		}
		ps.close();
		rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return listaLivro;
	}


	@Override
	public boolean remover(Livro l) throws SQLException {

			String sql = ("DELETE livro WHERE codLivro=(?)");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, l.getCodLivro());
			
			ps.execute();
			ps.close();
			
			if(ps.executeUpdate()>0){
				return true;
			} else{
				return false;
			}
		
	}

	@Override
	public boolean atualizarLivro(Livro l) throws SQLException{

			String sql = ("update livro set isbn = ?, nomelivro = ?, dataPub = ?, nomeAutor = ?, nomeEditora = ?, assunto = ?, status = ?, descricao = ?");
			sql +=(" WHERE codLivro = ?");
			
			PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, l.getIsbn());
			ps.setString(2, l.getNomeLivro());
            ps.setString(3, l.getDataPub());
            ps.setString(4, l.getNomeAutor());
            ps.setString(5, l.getNomeEditora());
            ps.setString(6, l.getAssunto());
            ps.setString(7, l.getStatus());
            ps.setString(8, l.getDescricao());
            ps.setInt(9, l.getCodLivro());
            
            
			ps.execute();
			ps.close();			
			
			if(ps.executeUpdate()>0){
				return true;
			} else{
				return false;
			}
    }
	


	public Livro getById(int codLivro) throws SQLException{
		String SQL = "SELECT * FROM clientes WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setInt(1, codLivro);
		
		ResultSet rs = ps.executeQuery();
		
		Livro li = new Livro();
		
		if (rs.first()){
			li.setCodLivro(rs.getInt("codLivro"));
			li.setIsbn(rs.getString("isbn"));
			li.setNomeLivro(rs.getString("nomeLivro"));
			li.setDataPub(rs.getString("dataPub"));
			li.setNomeAutor(rs.getString("nomeAutor"));
			li.setNomeEditora(rs.getString("nomeEditora"));
			li.setAssunto(rs.getString("assunto"));
			li.setStatus(rs.getString("status"));
			li.setDescricao(rs.getString("descricao"));
			
		}
		
		return li;
	}


}
