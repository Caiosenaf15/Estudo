package br.cefet.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        
        String requestURI = httpRequest.getRequestURI();
        
        // Páginas que não precisam de autenticação
        if (isPublicPage(requestURI)) {
            chain.doFilter(request, response);
            return;
        }
        
        // Verificar se o usuário está logado
        if (session != null && session.getAttribute("usuario") != null) {
            // Aplicar cores do usuário se disponíveis
            String corFundo = (String) session.getAttribute("corFundo");
            String corFonte = (String) session.getAttribute("corFonte");
            
            if (corFundo != null && corFonte != null) {
                // Adicionar atributos para uso nas JSPs
                request.setAttribute("corFundo", corFundo);
                request.setAttribute("corFonte", corFonte);
            }
            
            chain.doFilter(request, response);
        } else {
            // Se for requisição AJAX/JSON, retorna 401 ao invés de redirecionar
            String accept = httpRequest.getHeader("Accept");
            if (accept != null && accept.contains("application/json")) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.setContentType("application/json");
                httpResponse.getWriter().write("{\"error\":\"not authenticated\"}");
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            }
        }
    }
    
    private boolean isPublicPage(String requestURI) {
        return requestURI.endsWith("login.jsp") ||
               requestURI.endsWith("cadastro.jsp") ||
               requestURI.endsWith("LoginServlet") ||
               requestURI.endsWith("CadastroServlet") ||
               requestURI.contains("/imagens/") ||
               requestURI.contains("/css/") ||
               requestURI.contains("/js/");
    }
    
    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws ServletException {
        // Inicialização do filtro
    }
    
    @Override
    public void destroy() {
        // Limpeza do filtro
    }
} 