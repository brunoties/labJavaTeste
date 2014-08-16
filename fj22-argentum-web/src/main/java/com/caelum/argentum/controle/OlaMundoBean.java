package com.caelum.argentum.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean
public class OlaMundoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String mensagem = "Who are you?";
	
	private String nome;
	
	public OlaMundoBean() {
		System.out.println("OlaMundoBean");
		this.nome = "";
	}

	public void init() {
		System.out.println("init");
	}
	
	public void nomeFoiDigitado() {
		System.out.println("Nome foi digitado!");
	}

	public String getMensagem() {
		System.out.println("getMensagem");
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		System.out.println("setMensagem");
		this.mensagem = mensagem;
	}

	public String getNome() {
		System.out.println("getNome");
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("setNome");
		this.nome = nome;
	}

}
