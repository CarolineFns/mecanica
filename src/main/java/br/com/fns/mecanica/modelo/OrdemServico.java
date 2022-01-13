package br.com.fns.mecanica.modelo;

import java.util.ArrayList;
import java.util.List;

public class OrdemServico {

	private Long id;
	private Long valorTotal;
	private Long desconto;
	private List<Peca> pecas = new ArrayList<Peca>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getDesconto() {
		return desconto;
	}

	public void setDesconto(Long desconto) {
		this.desconto = desconto;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

}
