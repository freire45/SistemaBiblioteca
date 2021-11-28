package Biblioteca;

import javax.faces.application.FacesMessage;

import java.sql.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(value="emprestimo")
@RequestScoped

public class Emprestimo {
	private int codEmp;
	private Date dataEmp;
	private Date dataDevPrev;
	
	public int getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(int codEmp) {
		this.codEmp = codEmp;
	}
	public Date getDataEmp() {
		return dataEmp;
	}
	public void setDataEmp(Date dataEmp) {
		this.dataEmp = dataEmp;
	}
	public Date getDataDevPrev() {
		return dataDevPrev;
	}
	public void setDataDevPrev(Date dataDevPrev) {
		this.dataDevPrev = dataDevPrev;
	}



}
