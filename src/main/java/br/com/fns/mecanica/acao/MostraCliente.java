package br.com.fns.mecanica.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fns.mecanica.modelo.Banco;
import br.com.fns.mecanica.modelo.Cliente;

public class MostraCliente implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		System.out.println("Mostrando cliente " + id);

		Banco banco = new Banco();
		Cliente cliente = banco.getClienteById(id);

		request.setAttribute("cliente", cliente);

		return "forward:formMostraCliente.jsp";
	}

}
