package br.com.fns.mecanica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fns.mecanica.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String nome = null;
		String nomeClasse = "br.com.fns.mecanica.acao." + paramAcao;

		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		String[] tipoEEntrada = nome.split(":");
		if (tipoEEntrada[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEntrada[1]);
			rd.forward(request, response);
		} else
			response.sendRedirect(tipoEEntrada[1]);

	}

}
