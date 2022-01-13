package br.com.fns.mecanica.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static Long sequencial = 1L;
	private static List<Cliente> clientes = new ArrayList<Cliente>();

	static {
		clientes.add(new Cliente(sequencial++, "Caroline", "Caroline Fns", "carolfns"));
		clientes.add(new Cliente(sequencial++, "Rafael", "Rafael Souza", "rafaelstrong"));
		clientes.add(new Cliente(sequencial++, "Raquel", "Raquel Ferreira", "raquelfns"));
		clientes.add(new Cliente(sequencial++, "Elisangela", "Elisangela Santos", "elisangelafns"));
	}

	public List<Cliente> getListaClientes() {
		return Banco.clientes;
	}

	public void adicionaCliente(Cliente cliente) {
		cliente.setId(sequencial++);
		clientes.add(cliente);
	}

	public void alteraCliente(Cliente cliente) {
		Iterator<Cliente> clienteIterator = clientes.iterator();

		while (clienteIterator.hasNext()) {

			Cliente clienteAux = clienteIterator.next();

			if (clienteAux.getId().equals(cliente.getId())) {
				clienteAux.setNomeCompleto(cliente.getNomeCompleto());
				clienteAux.setLogin(cliente.getLogin());
				clienteAux.setNomeResumido(cliente.getNomeResumido());
			}
		}
	}

	public Cliente getClienteById(Long id) {
		for (Cliente cliente : clientes)
			if (cliente.getId() == id)
				return cliente;

		return null;
	}

	public void removeCliente(Long id) {
		Iterator<Cliente> clienteIterator = clientes.iterator();

		while (clienteIterator.hasNext()) {
			Cliente cliente = clienteIterator.next();

			if (cliente.getId() == id)
				clienteIterator.remove();
		}

	}

}
