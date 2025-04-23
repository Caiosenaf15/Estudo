package br.cefet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.cefet.dao.ViagemDao;
import br.cefet.model.Viagem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RelatorioViagemServlet")
public class RelatorioViagemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ViagemDao viagemDao;

    public void init() {
        viagemDao = new ViagemDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idViagem = Integer.parseInt(request.getParameter("id"));
        Viagem viagem = viagemDao.buscarPorId(idViagem);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Relatório de Viagem</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; padding: 40px; }");
        out.println(".header { display: flex; justify-content: space-between; align-items: center; }");
        out.println(".logo { width: 100px; height: 100px; border: 1px solid #000; display: flex; align-items: center; justify-content: center; font-weight: bold; }");
        out.println(".section { margin-top: 30px; }");
        out.println("</style></head><body>");

        out.println("<div class='header'>");
        out.println("<div><strong>Nome da Empresa:</strong> EcoRota<br><strong>CNPJ:</strong> 00.000.000/0000-00</div>");
        out.println("<div class='logo'><img src='imagens/ecorota-logo.png' alt='Logo' style='height:80px;' /></div>");
        out.println("</div>");

        out.println("<div class='section'><h3>Detalhes da Viagem</h3>");
        out.println("<p><strong>Motorista:</strong> " + viagem.getMotorista().getNome() + " &nbsp;&nbsp;&nbsp; <strong>ID:</strong> " + viagem.getMotorista().getId() + " &nbsp;&nbsp;&nbsp; <strong>Matrícula:</strong> " + viagem.getMotorista().getMatricula() + "</p>");
        out.println("<p><strong>Origem:</strong> " + viagem.getTrajeto().getPartida() + " &nbsp;&nbsp;&nbsp");
        out.println("<p><strong>Destino:</strong> " + viagem.getTrajeto().getDestino() + " &nbsp;&nbsp;&nbsp");
        out.println("<p><strong>Distância:</strong> " + viagem.getTrajeto().getDistancia() + " km &nbsp;&nbsp;&nbsp; <strong>Data:</strong> " + viagem.getDataFormatada() + "</p>");
        out.println("<p><strong>Número de passageiros:</strong> " + viagem.getPassageiros() + "</p>");

        out.println("<h4>Custos</h4>");
        out.println("<p><strong>Quantidade de combustível:</strong> " + String.format("%.2f", viagem.getTrajeto().getDistancia() / 10.0) + " litros</p>");
        out.println("<p><strong>Custo por passageiro:</strong> R$ " + String.format("%.2f", viagem.getCusto() / viagem.getPassageiros()) + "</p>");
        out.println("<p><strong>Custo por Km:</strong> R$ " + String.format("%.2f", viagem.getCusto() / viagem.getTrajeto().getDistancia()) + "</p>");
        out.println("<p><strong>Custo total:</strong> R$ " + String.format("%.2f", viagem.getCusto()) + "</p>");
        out.println("</div>");

        out.println("</body></html>");
    }
}
