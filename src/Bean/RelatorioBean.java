package Bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Biblioteca.Livro;
import DAO.LivroDAOImpl;
import DAO.relatorioIMPL;

@ManagedBean(name="relatorioBean")
@SessionScoped
public class RelatorioBean {
	
	relatorioIMPL rel = new relatorioIMPL();
	ArrayList<Livro> lista = new ArrayList<Livro>();
	LivroDAOImpl ldao = new LivroDAOImpl();
		
	public void geraRelatorio() throws SQLException{
		lista = (ArrayList<Livro>) ldao.pesquisaLivro();
		rel.imprimirPDFLivro(lista);
	}
	
}
