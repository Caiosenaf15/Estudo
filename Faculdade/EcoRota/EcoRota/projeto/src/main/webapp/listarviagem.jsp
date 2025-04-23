<%@ page import="java.util.List" %>
<%@ page import="br.cefet.model.Viagem" %>
<%@ page import="br.cefet.model.Motorista" %>
<%@ page import="br.cefet.model.Trajeto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Viagem> lista = (List<Viagem>) request.getAttribute("listaViagens");
    String termo = request.getParameter("termo");
    if (termo == null) termo = "";
%>
<html>
<head>
    <title>Lista de Viagens</title>
</head>
<body>
    <h2>Lista de Viagens</h2>

    <!-- Campo de busca -->
    <form method="get" action="viagem">
        <input type="hidden" name="acao" value="buscar" />
        <input type="text" name="termo" placeholder="Buscar por qualquer campo" value="<%= termo %>" />
        <input type="submit" value="Buscar" />
        <a href="viagem?acao=listar">Limpar</a>
    </form>
    <br/>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Motorista</th>
            <th>Trajeto</th>
            <th>Passageiros</th>
            <th>Data</th>
            <th>Custo</th>
            <th>Ações</th>
        </tr>

        <%
            if (lista != null && !lista.isEmpty()) {
                for (Viagem viagem : lista) {
        %>
        <tr>
            <td><%= viagem.getId() %></td>
            <td><%= viagem.getMotorista() != null ? viagem.getMotorista().getNome() : "N/A" %></td>
            <td>
                <%= viagem.getTrajeto() != null
                        ? viagem.getTrajeto().getPartida() + " → " + viagem.getTrajeto().getDestino()
                        : "N/A" %>
            </td>
            <td><%= viagem.getPassageiros() %></td>
            <td><%= viagem.getData() != null ? viagem.getDataFormatada() : "N/A" %></td>
            <td>R$ <%= String.format("%.2f", viagem.getCusto()) %></td>
            <td>
                <a href="viagem?acao=editar&id=<%= viagem.getId() %>">Editar</a> |
                <a href="viagem?acao=excluir&id=<%= viagem.getId() %>" onclick="return confirm('Deseja excluir esta viagem?')">Excluir</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">Nenhuma viagem encontrada.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
