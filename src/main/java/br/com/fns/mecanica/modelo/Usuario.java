package br.com.fns.mecanica.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	private String nomeResumido;
	private String nomeCompleto;
	private Endereco endereco;
	private List<Contato> contato = new ArrayList<Contato>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeResumido() {
		return nomeResumido;
	}

	public void setNomeResumido(String nomeResumido) {
		this.nomeResumido = nomeResumido;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

}
