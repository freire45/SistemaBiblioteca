package Biblioteca;

import javax.faces.application.FacesMessage;

import java.sql.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(value="devolucao")
@RequestScoped

public class Devolucao {
	private Date dataDev;
	private int codDev;
	
	public Date getDataDev() {
		return dataDev;
	}
	public void setDataDev(Date dataDev) {
		this.dataDev = dataDev;
	}
	public int getCodDev() {
		return codDev;
	}
	public void setCodDev(int codDev) {
		this.codDev = codDev;
	}
	



}
