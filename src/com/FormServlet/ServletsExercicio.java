package com.FormServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Util;



/**
 * Servlet implementation class ServletsExercicio
 */
@WebServlet("/ServletsExercicio")
public class ServletsExercicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsExercicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Util util = new Util();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		double salario = Double.parseDouble(request.getParameter("salario").replaceAll("," , "."));
		
		
		if (util.validarCPF(cpf) == true) {
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(" Seu nome e : " + util.inicialMaiuscula(nome) +
									 " Seu cpf e :" + util.imprimeCPF(cpf) +
									 " Seu telefone e: " + telefone +
									 " Seu salario e : " + String.format("%.2f",salario));
		
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(" Olá " + util.inicialMaiuscula(nome) + ", Erro " 
			                             + util.imprimeCPF(cpf) +  " CPF invalido !!!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
