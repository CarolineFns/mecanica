package br.com.fns.mecanica.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

	private List<OrdemServico> ordensServico = new ArrayList<OrdemServico>();

	public Cliente(Long id, String nomeResumido, String nomeCompleto, String login) {
		super();
		setId(id);
		setNomeResumido(nomeResumido);
		setNomeCompleto(nomeCompleto);
		setLogin(login);
	}

	public List<OrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

}
