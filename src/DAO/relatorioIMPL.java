package DAO;

import java.awt.Desktop;
import java.io.*;
import java.util.List;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Biblioteca.Livro;


public class relatorioIMPL {
	
	public void imprimirPDFLivro(List<Livro> listLivro)
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
			PdfPTable tabela = new PdfPTable(9);
			tabela.addCell(cabecalho);
			tabela.addCell("Código");
			tabela.addCell("Livro");
			tabela.addCell("ISBN");
			tabela.addCell("data Publicação");
			tabela.addCell("Autor");
			tabela.addCell("Editora");
			tabela.addCell("Assunto");
			tabela.addCell("status");
			tabela.addCell("descrição");
		
			for(Livro l : listLivro)
			{
				tabela.addCell(Integer.toString(l.getCodLivro()));
				tabela.addCell(l.getNomeLivro());
				tabela.addCell(l.getIsbn());
				tabela.addCell(l.getDataPub());
				tabela.addCell(l.getNomeAutor());
				tabela.addCell(l.getNomeEditora());
				tabela.addCell(l.getAssunto());
				tabela.addCell(l.getStatus());
				tabela.addCell(l.getDescricao());
				
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

	}
	

}


