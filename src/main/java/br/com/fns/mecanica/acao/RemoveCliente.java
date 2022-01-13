package br.com.fns.mecanica.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fns.mecanica.modelo.Banco;

public class RemoveCliente implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		System.out.println("Removendo cliente " + id);

		Banco banco = new Banco();
		banco.removeCliente(id);

		return "redirect:entrada?acao=ListaClientes";
	}

}
