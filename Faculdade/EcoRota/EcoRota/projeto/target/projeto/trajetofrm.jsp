<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerenciar Trajetos</title>
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
    .container {
        width: 100%;
        max-width: 800px;
    }

    h1 {
        color: #36a96d;
        font-size: 32px;
        margin-bottom: 10px;
        text-align: center;
    }

    h2 {
        color: #2c7a52;
        margin-top: 40px;
        font-size: 24px;
        text-align: center;
    }

    form {
        background-color: #ffffff;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        margin-bottom: 40px;
    }

    form label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
        color: #444;
    }

    form input[type="text"],
    form input[type="number"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    form input[type="submit"] {
        background-color: #36a96d;
        color: white;
        border: none;
        padding: 12px 20px;
        border-radius: 6px;
        cursor: pointer;
        font-size: 16px;
    }

    form input[type="submit"]:hover {
        background-color: #2f8e5d;
    }

    a {
        text-decoration: none;
        color: #36a96d;
    }

    a:hover {
        text-decoration: underline;
    }

    .message {
        padding: 12px;
        border-radius: 5px;
        margin-bottom: 20px;
        font-weight: bold;
        text-align: center;
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

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        margin-top: 20px;
    }

    table th, table td {
        padding: 14px;
        text-align: left;
        border-bottom: 1px solid #eee;
    }

    table th {
        background-color: #e8f5ec;
        color: #2c7a52;
    }

    table tbody tr:hover {
        background-color: #f1fff5;
    }

    .action-links a {
        margin-right: 12px;
        font-weight: bold;
        color: #2d8659;
    }

    .action-links a:hover {
        color: #1b5e3d;
    }

    .center-link {
        display: block;
        text-align: center;
        margin-top: 10px;
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
    <div class="container">
    <h1>Gerenciar Trajetos</h1>

    <c:if test="${not empty mensagemSucesso}">
        <div class="message success">${mensagemSucesso}</div>
    </c:if>
    <c:if test="${not empty mensagemErro}">
        <div class="message error">${mensagemErro}</div>
    </c:if>

    <h2>Adicionar Novo Trajeto</h2>
    <form action="TrajetoServlet?action=salvar" method="post">
        <input type="hidden" name="action" value="adicionar">
        <label for="partida">Partida:</label>
        <input type="text" id="partida" name="partida" required><br>
        <label for="destino">Destino:</label>
        <input type="text" id="destino" name="destino" required><br>
        <label for="distancia">Distância (KM):</label>
        <input type="number" step="0.01" id="distancia" name="distancia" min="0" required><br>
        <label for="gastoPorKm">Gasto por KM (R$):</label>
        <input type="number" step="0.01" id="gastoPorKm" name="gastoPorKm" min="0" required><br>
        <input type="submit" value="Adicionar Trajeto">
    </form>

    <h2>Lista de Trajetos</h2>
    <form action="TrajetoServlet" method="get">
        <input type="hidden" name="action" value="listar"/>
        <input type="submit" value="Atualizar"/>
    </form>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Partida</th>
                <th>Destino</th>
                <th>Distância (KM)</th>
                <th>Gasto por KM (R$)</th>
                <th>Ações</th>
            </tr>
        </thead>
        
        <tbody>
            <c:forEach var="trajeto" items="${listaTrajetos}">
                <tr>
                    <td><c:out value="${trajeto.id}"/></td>
                    <td><c:out value="${trajeto.partida}"/></td>
                    <td><c:out value="${trajeto.destino}"/></td>
                    <td><c:out value="${trajeto.distancia}"/></td>
                    <td><c:out value="${trajeto.gastoPorKm}"/></td>
                    <td class="action-links">
                        <a href="TrajetoServlet?action=editar&id=${trajeto.id}">Editar</a>
                        <a href="TrajetoServlet?action=excluir&id=${trajeto.id}" onclick="return confirm('Tem certeza que deseja excluir este trajeto?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty listaTrajetos}">
                <tr>
                    <td colspan="6">Nenhum trajeto cadastrado.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
    </div>
</body>
</html>