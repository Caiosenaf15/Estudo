package br.cefet.controller;

import java.io.IOException;

import br.cefet.dao.UsuarioDao;
import br.cefet.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario user = usuarioDao.buscarPorUsuario(usuario);
        if (user != null && user.getSenhaHash().equals(hashSenha(senha))) {
            request.getSession().setAttribute("usuario", usuario);
            request.getSession().setAttribute("token", java.util.UUID.randomUUID().toString());
            // Salva preferências na session
            request.getSession().setAttribute("corFundo", user.getCorFundo());
            request.getSession().setAttribute("corFonte", user.getCorFonte());
            response.sendRedirect("menu.jsp");
        } else {
            request.setAttribute("mensagemErro", "Usuário ou senha inválidos!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private String hashSenha(String senha) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
} 