// src/main/java/br/cefet/controller/MotoristaServlet.java
package br.cefet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import br.cefet.dao.MotoristaDao;
import br.cefet.model.Motorista;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MotoristaServlet")
public class MotoristaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MotoristaDao motoristaDao;

    public MotoristaServlet() {
        super();
        motoristaDao = new MotoristaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String accept = request.getHeader("Accept");
        if (action == null) {
            action = "listar";
        }
        if ("application/json".equals(accept) || "json".equals(request.getParameter("format"))) {
            listarMotoristasJson(request, response);
            return;
        }
        switch (action) {
            case "listar":
                listarMotoristas(request, response);
                break;

            case "novo":
                exibirFormularioNovo(request, response);
                break;
            case "editar":
                exibirFormularioEdicao(request, response);
                break;
            case "excluir":
                excluirMotorista(request, response);
                break;
            default:
                listarMotoristas(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String contentType = request.getContentType();
        if (action == null && contentType != null && contentType.contains("application/json")) {
            salvarMotoristaJson(request, response);
            return;
        }
        if (action == null) {
            action = "salvar";
        }
        switch (action) {
            case "salvar":
                salvarMotorista(request, response);
                break;

            case "atualizar":
                atualizarMotorista(request, response);
                break;
            default:
                listarMotoristas(request, response);
                break;
        }
    }

    private void listarMotoristas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Motorista> listaMotoristas = motoristaDao.listarTodos();
        request.setAttribute("listaMotoristas", listaMotoristas);
        request.getRequestDispatcher("motoristafrm.jsp").forward(request, response);
    }

    private void exibirFormularioNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("motoristafrm.jsp").forward(request, response);
    }

    private void salvarMotorista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String matricula = request.getParameter("matricula");

        Motorista novoMotorista = new Motorista(nome, idade, matricula);
        motoristaDao.salvar(novoMotorista);

        request.setAttribute("mensagemSucesso", "Motorista cadastrado com sucesso!");
        listarMotoristas(request, response);
    }



    private void exibirFormularioEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Motorista motorista = motoristaDao.buscarPorId(id);

        if (motorista != null) {
            request.setAttribute("motorista", motorista);
            request.getRequestDispatcher("editarmotorista.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagemErro", "Motorista não encontrado para edição.");
            listarMotoristas(request, response);
        }
    }

    private void atualizarMotorista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String matricula = request.getParameter("matricula");

        Motorista motoristaAtualizado = new Motorista(id, nome, idade, matricula);
        motoristaDao.atualizar(motoristaAtualizado);

        request.setAttribute("mensagemSucesso", "Motorista atualizado com sucesso!");
        listarMotoristas(request, response);
    }

    private void excluirMotorista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            motoristaDao.excluir(id);
            request.setAttribute("mensagemSucesso", "Motorista excluído com sucesso!");
        } catch (SQLException e) {
            if (e.getMessage().toLowerCase().contains("foreign key") || e.getMessage().toLowerCase().contains("a foreign key constraint fails")) {
                request.setAttribute("mensagemErro", "Não é possível excluir o motorista, pois ele está associado a uma viagem.");
            } else {
                request.setAttribute("mensagemErro", "Erro ao excluir o motorista.");
                e.printStackTrace();
            }
        }
        listarMotoristas(request, response);
    }

    private void listarMotoristasJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String matricula = request.getParameter("matricula");
        String idadeStr = request.getParameter("idade");
        List<Motorista> lista = motoristaDao.listarTodos();
        if (nome != null && !nome.isEmpty()) {
            lista = lista.stream().filter(m -> m.getNome().toLowerCase().contains(nome.toLowerCase())).toList();
        }
        if (matricula != null && !matricula.isEmpty()) {
            lista = lista.stream().filter(m -> m.getMatricula().toLowerCase().contains(matricula.toLowerCase())).toList();
        }
        if (idadeStr != null && !idadeStr.isEmpty()) {
            try {
                int idade = Integer.parseInt(idadeStr);
                lista = lista.stream().filter(m -> m.getIdade() == idade).toList();
            } catch (NumberFormatException ignored) {}
        }
        response.setContentType("application/json;charset=UTF-8");
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().serializeNulls().create();
        String json = gson.toJson(lista);
        System.out.println(json);
        response.getWriter().write(json);
    }



    private void salvarMotoristaJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Gson gson = new Gson();
            Motorista motorista = gson.fromJson(request.getReader(), Motorista.class);
            motoristaDao.salvar(motorista);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"status\":\"ok\",\"message\":\"Motorista salvo com sucesso\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"status\":\"error\",\"message\":\"Erro ao salvar motorista\"}");
        }
    }
}
