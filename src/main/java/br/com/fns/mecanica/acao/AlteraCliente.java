package br.com.fns.mecanica.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fns.mecanica.modelo.Banco;
import br.com.fns.mecanica.modelo.Cliente;

public class AlteraCliente implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando novo cliente");

		Banco banco = new Banco();

		Cliente cliente = banco.getClienteById(Long.parseLong(request.getParameter("id")));
		cliente.setLogin(request.getParameter("login"));
		cliente.setNomeCompleto(request.getParameter("nomeCompleto"));
		cliente.setNomeResumido(request.getParameter("nomeResumido"));

		return "redirect:entrada?acao=ListaClientes";

	}

}
