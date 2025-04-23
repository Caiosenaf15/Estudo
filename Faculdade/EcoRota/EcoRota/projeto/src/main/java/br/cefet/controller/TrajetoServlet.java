// src/main/java/br/cefet/controller/TrajetoServlet.java
package br.cefet.controller;

import br.cefet.dao.TrajetoDao;
import br.cefet.model.Trajeto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/TrajetoServlet")
public class TrajetoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrajetoDao trajetoDAO;

    public TrajetoServlet() {
        super();
        trajetoDAO = new TrajetoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listarTrajetos(request, response);
                break;
            case "novo":
                exibirFormularioNovo(request, response); // Novo método para exibir o formulário de cadastro
                break;
            case "editar":
                exibirFormularioEdicao(request, response);
                break;
            case "excluir":
                excluirTrajeto(request, response);
                break;
            default:
                listarTrajetos(request, response);
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
                salvarTrajeto(request, response);
                break;
            case "atualizar":
                atualizarTrajeto(request, response);
                break;
            case "listar":
                listarTrajetos(request, response);
            default:
                listarTrajetos(request, response);
                break;
        }
    }

    private void listarTrajetos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Trajeto> listaTrajetos = trajetoDAO.listarTodos();
        request.setAttribute("listaTrajetos", listaTrajetos);
        request.getRequestDispatcher("trajetofrm.jsp").forward(request, response);
        request.getRequestDispatcher("viagemfrm.jsp").forward(request, response);
    }

    private void exibirFormularioNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("novotrajeto.jsp").forward(request, response);
    }

    private void salvarTrajeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String partida = request.getParameter("partida");
        String destino = request.getParameter("destino");
        double distancia = Double.parseDouble(request.getParameter("distancia"));
        double gastoPorKm = Double.parseDouble(request.getParameter("gastoPorKm")); // Adicionado

        Trajeto novoTrajeto = new Trajeto(partida, destino, distancia, gastoPorKm);
        trajetoDAO.salvar(novoTrajeto);

        request.setAttribute("mensagemSucesso", "Trajeto cadastrado com sucesso!");
        listarTrajetos(request, response);
    }

    private void exibirFormularioEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Trajeto trajeto = trajetoDAO.buscarPorId(id);

        if (trajeto != null) {
            request.setAttribute("trajeto", trajeto);
            request.getRequestDispatcher("editartrajeto.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagemErro", "Trajeto não encontrado para edição.");
            listarTrajetos(request, response);
        }
    }

    private void atualizarTrajeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String partida = request.getParameter("partida");
        String destino = request.getParameter("destino");
        double distancia = Double.parseDouble(request.getParameter("distancia"));
        double gastoPorKm = Double.parseDouble(request.getParameter("gastoPorKm")); // Adicionado

        Trajeto trajetoAtualizado = new Trajeto(id, partida, destino, distancia, gastoPorKm);
        trajetoDAO.atualizar(trajetoAtualizado); // Chamada corrigida para 'atualizar'

        request.setAttribute("mensagemSucesso", "Trajeto atualizado com sucesso!");
        listarTrajetos(request, response);
    }

    private void excluirTrajeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));

    if (trajetoDAO.possuiViagensAssociadas(id)) {
        request.setAttribute("mensagemErro", "Não é possível excluir o trajeto. Existem viagens associadas a ele.");
    } else {
        trajetoDAO.excluir(id);
        request.setAttribute("mensagemSucesso", "Trajeto excluído com sucesso!");
    }

    listarTrajetos(request, response);
}

}