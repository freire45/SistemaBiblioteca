package Bean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import Biblioteca.Livro;
import DAO.LivroDAOImpl;


@ManagedBean(name="livroBean")
@SessionScoped
public class LivroBean implements java.io.Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
   private Livro liv = new Livro();
   private DataModel<Livro> listLivro;
   
   
   public String apagar(){
	   String retorno="livroConsultar";
	   
	   try{
	   LivroDAOImpl ldao = new LivroDAOImpl();
	   if(ldao.remover(liv)){
		   retorno = "livroConsultar";
	   }
	   }catch(Exception ex){
		   
	   }
	   return retorno;
   }
   
   public String atualizarLivro(){
		String retorno = "livroConsultar";
		
		try {
			LivroDAOImpl lidao = new LivroDAOImpl();
			if (lidao.atualizarLivro(liv)) {
				retorno = "livroConsultar";
			}
		} catch (Exception ex) {

		}

		return retorno;
	}
   
   public DataModel<Livro> getListLivro(){
	   LivroDAOImpl livdao = new LivroDAOImpl();
	   try {
		List<Livro> lista = livdao.pesquisaLivro();
		listLivro = new ListDataModel<Livro>(lista);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return listLivro;
   }
	

public String adicionaLivro(){
	   String retorno="livroConsultar";
	   
	   try{
	   LivroDAOImpl ldao = new LivroDAOImpl();
	   if(ldao.adicionarLivro(liv)){
		   retorno = "livroConsultar";
	   }
	   }catch(Exception ex){
		   
	   }
	   return retorno;
   }

   public void selecionarReg(){
	   this.liv = listLivro.getRowData();
   }
   
   public void novo(){
	   this.liv = new Livro();
   }
   

    public void setListLivro(DataModel<Livro> listLivro) {
	   this.listLivro = listLivro;
    }

    public Livro getLiv() {
	   return liv;
    }

    public void setLiv(Livro liv) {
	   this.liv = liv;
	

    }





}
