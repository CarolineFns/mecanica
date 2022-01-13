package br.com.fns.mecanica.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fns.mecanica.modelo.Banco;
import br.com.fns.mecanica.modelo.Cliente;

public class ListaClientes implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Cliente> clientes = banco.getListaClientes();

		request.setAttribute("clientes", clientes);

		return "forward:listaClientes.jsp";
	}

}
