package Biblioteca;

import javax.faces.application.FacesMessage;

import java.sql.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(value="cliente")
@RequestScoped


public class Cliente {
	private String nomeCliente;
	private String cpf;
	private String rg;
	private Date dataNasc;
	private String email;
	private String telResid;
	private String telContato;
	private String telCel;
	private String rua;
	private String numero;
	private String complem;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String opcao;
	
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelResid() {
		return telResid;
	}
	public void setTelResid(String telResid) {
		this.telResid = telResid;
	}
	public String getTelContato() {
		return telContato;
	}
	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}
	public String getTelCel() {
		return telCel;
	}
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplem() {
		return complem;
	}
	public void setComplem(String complem) {
		this.complem = complem;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	

}
