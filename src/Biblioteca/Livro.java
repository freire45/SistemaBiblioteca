package Biblioteca;



public class Livro implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codLivro;
    private String nomeLivro;
	private String isbn;
    private String dataPub;
    private String nomeAutor;
    private String nomeEditora;
    private String assunto;
    private String status;
    private String descricao;
    
    
	public int getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDataPub() {
		return dataPub;
	}
	public void setDataPub(String dataPub) {
		this.dataPub = dataPub;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getNomeEditora() {
		return nomeEditora;
	}
	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
