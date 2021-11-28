package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Cliente;
import Interfaces.ClienteDAO;

public class ClienteDAOImpl implements ClienteDAO {
	
	Connection con;
	
	public ClienteDAOImpl(){
		GenericDAOImpl gDAO = new GenericDAOImpl();
		con = gDAO.getConnection();
    } 


	@Override
	public void adicionarCliente(Cliente c) throws SQLException {
		try
		{
			String sql = ("INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getNomeCliente());
			ps.execute();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}


	@Override
	public void atualizarCliente(Cliente a) throws SQLException{
		try
		{
			String sql = ("UPDATE cliente SET nomeCliente=(?) WHERE cpf=(?)");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getNomeCliente());
			ps.setString(2, a.getCpf());
			ps.execute();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}


/** Espero que esse pesquisar funcione. Mas eu não entendi porque no public já estava "pesquisa Bairro", ou
era pra pesquisarmos bairro msm aqui? Eu não lembro se conversamos sobre isso na sala o.o **/
	@Override
	public List<Cliente> pesquisaCliente() throws SQLException {
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

		try
		{
		String sql = ("SELECT * FROM cliente ORDER BY nomeCliente ASC");
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Cliente a = new Cliente();
			a.setCpf(rs.getString("cpf"));
			a.setNomeCliente(rs.getString("nomeCliente"));
			listaCliente.add(a);
		}
		ps.close();
		rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return listaCliente;
	}


	@Override
	public void remover(Cliente a) throws SQLException {
		try
		{
			String sql = ("DELETE cliente WHERE cpf=(?)");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getCpf());
			ps.execute();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}

/**Exemplo de como gerar um pdf de um outro projeto que encontrei, no caso do autor
	public void imprimirPDFAutor(ArrayList<Autor> lista)
	{
		com.itextpdf.text.Document doc = null;
		OutputStream outputStream = null;
		String arquivo = "Autor";
		String celulaCodigo = "Código do Autor";
		String celulaNome = "Nome do Autor";
		
		try
		{
			doc = new com.itextpdf.text.Document (PageSize.A4,30,20,20,30);
			outputStream = new FileOutputStream(arquivo + ".pdf");
			PdfWriter.getInstance(doc, outputStream);
			doc.open();
			//Paragraph p1 = new Paragraph("Autores");
			//doc.add(p1);
			PdfPCell cabecalho = new PdfPCell(new Paragraph("Relatório " + arquivo));
			cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
			cabecalho.setBorder(PdfPCell.BOX);
			cabecalho.setBackgroundColor(new BaseColor(255,50,50));
			cabecalho.setColspan(5);
			PdfPTable tabela = new PdfPTable(2);
			tabela.addCell(cabecalho);
			tabela.addCell(celulaCodigo);
			tabela.addCell(celulaNome);
		
			for(Autor a : lista)
			{
				tabela.addCell(Integer.toString(a.getAutorId()));
				tabela.addCell(a.getNomeAutor());
			}
		
			doc.add(tabela);
			Desktop.getDesktop().open(new File(arquivo + ".pdf"));
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(doc != null)
			{
				doc.close();
			}
		}
		
	}**/

/** Aqui outro exemplo de como imprimir relatório de livros mesmo em pdf
	public void imprimirPDFLivro(ArrayList<Livro> lista)
	{
		com.itextpdf.text.Document doc = null;
		OutputStream outputStream = null;
		String arquivo = "Livro";
		
		try
		{
			doc = new com.itextpdf.text.Document (PageSize.A4,30,20,20,30);
			outputStream = new FileOutputStream(arquivo + ".pdf");
			PdfWriter.getInstance(doc, outputStream);
			doc.open();
			PdfPCell cabecalho = new PdfPCell(new Paragraph("Relatório " + arquivo));
			cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
			cabecalho.setBorder(PdfPCell.BOX);
			cabecalho.setBackgroundColor(new BaseColor(255,50,50));
			cabecalho.setColspan(9);
			PdfPTable tabela = new PdfPTable(5);
			tabela.addCell(cabecalho);
			//tabela.addCell("Código");
			tabela.addCell("Código");
			tabela.addCell("Nome");
			tabela.addCell("Qtde Disponível");
			//tabela.addCell("CPF");
			//tabela.addCell("RG");
			tabela.addCell("ISBN");
			//tabela.addCell("Tel");
			tabela.addCell("Status");
		
			for(Livro l : lista)
			{
				//tabela.addCell(Integer.toString(u.getUsuarioId()));
				tabela.addCell(Integer.toString(l.getLivroId()));
				tabela.addCell(l.getNomeLivro());
				tabela.addCell(Integer.toString(l.getQuantidadeDisponivel()));
				//tabela.addCell(u.getCpf().toString());
				//tabela.addCell(u.getRg().toString());
				tabela.addCell(l.getISBN());
				//tabela.addCell(u.getTelefoneContato().toString());
				tabela.addCell(l.getStatus().toString());
				
			}
		
			doc.add(tabela);
			Desktop.getDesktop().open(new File(arquivo + ".pdf"));
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(doc != null)
			{
				doc.close();
			}
		}
		
	}**/
