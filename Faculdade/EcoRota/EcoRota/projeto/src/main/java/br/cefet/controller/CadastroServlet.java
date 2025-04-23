package br.cefet.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.cefet.dao.UsuarioDao;
import br.cefet.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String corFundo = request.getParameter("corFundo");
        String corFonte = request.getParameter("corFonte");
        String senhaHash = hashSenha(senha);
        UsuarioDao usuarioDao = new UsuarioDao();
        if (usuarioDao.buscarPorUsuario(usuario) != null) {
            request.setAttribute("mensagemErro", "Usuário já existe!");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return;
        }
        Usuario novoUsuario = new Usuario(usuario, senhaHash, corFundo, corFonte);
        usuarioDao.salvar(novoUsuario);
        response.sendRedirect("login.jsp");
    }

    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
} 