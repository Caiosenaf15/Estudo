<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerenciar Viagens</title>
    <style>
        body {
    font-family: 'Segoe UI', sans-serif;
    background-color: #f5fff9;
    margin: 0;
    padding: 100px 20px 40px; /* top aumentado */
    color: #333;
    display: flex;
    flex-direction: column;
    align-items: center;
}

 header {
    background-color: #36a96d;
    padding: 15px 20px;
    color: white;
    position: fixed; /* fixado no topo */
    top: 0;
    left: 0;
    width: 100%;     /* ocupa toda a largura */
    z-index: 1000;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.navbar {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    align-items: center;
}


.logo {
    display: flex;
    align-items: center;
}

.logo img {
    height: 36px;
    margin-right: 10px;
}

.logo span {
    font-size: 22px;
    font-weight: bold;
}

nav a {
    margin-left: 20px;
    color: white;
    text-decoration: none;
    font-size: 16px;
    font-weight: 500;
}

nav a:hover {
    text-decoration: underline;
}
        form {
            margin-bottom: 30px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
            max-width: 800px;
            width: 100%;
        }

        form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        form input[type="number"],
        form input[type="date"],
        form select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"] {
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form input[type="submit"]:hover {
            background-color: #218838;
        }

        table {
            width: 100%;
            max-width: 1000px;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
        }

        table th, table td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        table th {
            background-color: #f2f2f2;
        }

        .action-links a {
            margin-right: 10px;
            text-decoration: none;
            color: #007bff;
        }

        .action-links a:hover {
            text-decoration: underline;
        }

        .message {
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 4px;
            max-width: 800px;
            width: 100%;
        }

        .success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }

        .error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }

        h2 {
            margin-top: 40px;
        }
    </style>
</head>
<body>

<header>
    <div class="navbar">
        <div class="logo">
            <img src="imagens/ecorota-logo.png" alt="EcoRota" />
            <span>EcoRota</span>
        </div>
        <nav>
            <a href="trajetofrm.jsp">Trajeto</a>
            <a href="motoristafrm.jsp">Motorista</a>
            <a href="viagemfrm.jsp">Viagem</a>
        </nav>
    </div>
</header>

<c:if test="${not empty mensagemSucesso}">
    <div class="message success">${mensagemSucesso}</div>
</c:if>
<c:if test="${not empty mensagemErro}">
    <div class="message error">${mensagemErro}</div>
</c:if>

<h2>Adicionar Nova Viagem</h2>

<form action="ViagemServlet" method="post">
    <input type="hidden" name="action" value="salvar">
    
    <select id="motoristaId" name="motoristaId" required>
        <option value="">Selecione um motorista</option>
        <c:forEach var="m" items="${motoristas}">
            <option value="${m.id}">${m.nome}</option>
        </c:forEach>
    </select>

    <label for="trajetoId">Trajeto:</label>
    <select id="trajetoId" name="trajetoId" required>
        <option value="">Selecione um trajeto</option>
        <c:forEach var="t" items="${trajetos}">
            <option value="${t.id}">
                ${t.partida} para ${t.destino} (${t.distancia} KM)
            </option>
        </c:forEach>
    </select>

    <label for="passageiros">Número de Passageiros:</label>
    <input type="number" id="passageiros" name="passageiros" min="1" required>

    <label for="data">Data da Viagem:</label>
    <input type="date" id="data" name="data" required>

    <input type="submit" value="Adicionar Viagem">
</form>

<h2>Lista de Viagens</h2>
<form action="ViagemServlet" method="get">
        <input type="hidden" name="action" value="listar"/>
        <input type="submit" value="Atualizar"/>
    </form>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Motorista</th>
            <th>Trajeto</th>
            <th>Passageiros</th>
            <th>Data</th>
            <th>Custo (R$)</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="viagem" items="${listaViagens}">
            <tr>
                <td><c:out value="${viagem.id}" /></td>
                <td><c:out value="${viagem.motorista.nome}" /></td>
                <td><c:out value="${viagem.trajeto.partida} para ${viagem.trajeto.destino}" /></td>
                <td><c:out value="${viagem.passageiros}" /></td>
                <td><c:out value="${viagem.dataFormatada}" /></td>
                <td><c:out value="R$ ${String.format('%.2f', viagem.custo)}" /></td>
                <td class="action-links">
                    <a href="ViagemServlet?action=editar&id=${viagem.id}">Editar</a>
                    <a href="ViagemServlet?action=excluir&id=${viagem.id}" onclick="return confirm('Tem certeza que deseja excluir esta viagem?');">Excluir</a>
                    <a href="RelatorioViagemServlet?id=${viagem.id}" target="_blank">Relatório</a>
                </td>
            </tr>
        </c:forEach>
        
    </tbody>
</table>

</body>
</html>