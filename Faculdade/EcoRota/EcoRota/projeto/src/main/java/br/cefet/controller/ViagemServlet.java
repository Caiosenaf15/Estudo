
package br.cefet.controller;

import br.cefet.dao.MotoristaDao;
import br.cefet.dao.TrajetoDao;
import br.cefet.dao.ViagemDao;
import br.cefet.model.Motorista;
import br.cefet.model.Trajeto;
import br.cefet.model.Viagem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate; // Importa java.time.LocalDate
import java.time.format.DateTimeParseException; // Para lidar com erros de parsing
import java.util.List;

@WebServlet("/ViagemServlet")
public class ViagemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ViagemDao viagemDAO;
    private MotoristaDao motoristaDAO;
    private TrajetoDao trajetoDAO;

    public ViagemServlet() {
        super();
        viagemDAO = new ViagemDao();
        motoristaDAO = new MotoristaDao();
        trajetoDAO = new TrajetoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listarViagens(request, response);
                break;
            case "novo":
                exibirFormularioNovo(request, response);
                break;
            case "editar":
                exibirFormularioEdicao(request, response);
                break;
            case "excluir":
                excluirViagem(request, response);
                break;
            default:
                listarViagens(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "salvar";
        }

        switch (action) {
            case "salvar":
                salvarViagem(request, response);
                break;
            case "atualizar":
                atualizarViagem(request, response);
                break;
            default:
                listarViagens(request, response);
                break;
        }
    }

    private void listarViagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Viagem> listaViagens = viagemDAO.listarTodos();
    List<Motorista> motoristas = motoristaDAO.listarTodos();
    List<Trajeto> trajetos = trajetoDAO.listarTodos();

    request.setAttribute("listaViagens", listaViagens); 
    request.setAttribute("motoristas", motoristas);
    request.setAttribute("trajetos", trajetos);

    request.getRequestDispatcher("viagemfrm.jsp").forward(request, response);
}


    private void exibirFormularioNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("motoristas", motoristaDAO.listarTodos());
        request.setAttribute("trajetos", trajetoDAO.listarTodos());
        request.getRequestDispatcher("viagemfrm.jsp").forward(request, response);
    }

    private void salvarViagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int motoristaId = Integer.parseInt(request.getParameter("motoristaId"));
        int trajetoId = Integer.parseInt(request.getParameter("trajetoId"));
        int passageiros = Integer.parseInt(request.getParameter("passageiros"));
        String dataStr = request.getParameter("data"); // Data como String

        LocalDate data = null;
        try {
            data = LocalDate.parse(dataStr); // Tenta parsear a string para LocalDate
        } catch (DateTimeParseException e) {
            request.setAttribute("mensagemErro", "Formato de data inválido. Use AAAA-MM-DD.");
            exibirFormularioNovo(request, response); // Retorna ao formulário com erro
            return;
        }

        Motorista motorista = motoristaDAO.buscarPorId(motoristaId);
        Trajeto trajeto = trajetoDAO.buscarPorId(trajetoId);

        if (motorista != null && trajeto != null) {
            Viagem novaViagem = new Viagem(motorista, trajeto, passageiros, data); // Passa LocalDate
            viagemDAO.salvar(novaViagem);
            request.setAttribute("mensagemSucesso", "Viagem cadastrada com sucesso!");
        } else {
            request.setAttribute("mensagemErro", "Motorista ou Trajeto não encontrado. Viagem não cadastrada.");
        }
        listarViagens(request, response);
    }

    private void exibirFormularioEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Viagem viagem = viagemDAO.buscarPorId(id);

        if (viagem != null) {
            request.setAttribute("viagem", viagem);
            request.setAttribute("motoristas", motoristaDAO.listarTodos());
            request.setAttribute("trajetos", trajetoDAO.listarTodos());
            request.getRequestDispatcher("editarviagem.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagemErro", "Viagem não encontrada para edição.");
            listarViagens(request, response);
        }
    }

    private void atualizarViagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int motoristaId = Integer.parseInt(request.getParameter("motoristaId"));
        int trajetoId = Integer.parseInt(request.getParameter("trajetoId"));
        int passageiros = Integer.parseInt(request.getParameter("passageiros"));
        String dataStr = request.getParameter("data");

        LocalDate data = null;
        try {
            data = LocalDate.parse(dataStr); // Tenta parsear a string para LocalDate
        } catch (DateTimeParseException e) {
            request.setAttribute("mensagemErro", "Formato de data inválido. Use AAAA-MM-DD.");
            exibirFormularioEdicao(request, response); // Retorna ao formulário com erro
            return;
        }

        Motorista motorista = motoristaDAO.buscarPorId(motoristaId);
        Trajeto trajeto = trajetoDAO.buscarPorId(trajetoId);

        if (motorista != null && trajeto != null) {
            Viagem viagemAtualizada = new Viagem(id, motorista, trajeto, passageiros, data); // Passa LocalDate
            viagemDAO.atualizar(viagemAtualizada);
            request.setAttribute("mensagemSucesso", "Viagem atualizada com sucesso! Custo: R$ " + String.format("%.2f", viagemAtualizada.getCusto()));
        } else {
            request.setAttribute("mensagemErro", "Motorista ou Trajeto não encontrado durante a atualização.");
        }
        listarViagens(request, response);
    }

    private void excluirViagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        viagemDAO.excluir(id);

        request.setAttribute("mensagemSucesso", "Viagem excluída com sucesso!");
        listarViagens(request, response);
    }
}