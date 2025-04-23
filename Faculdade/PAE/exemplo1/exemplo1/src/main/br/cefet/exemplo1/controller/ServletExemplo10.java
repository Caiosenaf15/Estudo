package br.cefet.exemplo1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletExemplo10")
public class ServletExemplo10 extends HttpServlet {
private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String n = request.getParameter("n");
        String salarioString = request.getParameter("salario");
        date data = request.getParameter("data");
        String estado = request.getParameter("uf");

        float salario = Float.parseFloat(salarioString);

        salario = salario * 1.1;

        request.setAttribute("n", n);
        request.setAttribute("salario", salario);
        request.setAttribute("data", data);
        request.setAttribute("uf", estado);
        RequestDispatcher rd = request.RequestDispatcher("exemplo10.jsp");
        rd.forward(request, response);

    }

}