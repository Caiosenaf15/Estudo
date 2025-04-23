<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Viagem</title>
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
    <h1>Editar Viagem</h1>

    <form action="ViagemServlet" method="post">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${viagem.id}">

        <label for="motoristaId">Motorista:</label>
        <select id="motoristaId" name="motoristaId" required>
            <c:forEach var="m" items="${motoristas}">
                <option value="${m.id}" ${viagem.motorista.id == m.id ? 'selected' : ''}>
                    <c:out value="${m.nome}"/>
                </option>
            </c:forEach>
        </select><br>

        <label for="trajetoId">Trajeto:</label>
        <select id="trajetoId" name="trajetoId" required>
            <c:forEach var="t" items="${trajetos}">
                <option value="${t.id}" ${viagem.trajeto.id == t.id ? 'selected' : ''}>
                    <c:out value="${t.partida}"/> para <c:out value="${t.destino}"/> (<c:out value="${t.distancia}"/> KM)
                </option>
            </c:forEach>
        </select><br>

        <label for="passageiros">Número de Passageiros:</label>
        <input type="number" id="passageiros" name="passageiros" value="<c:out value="${viagem.passageiros}"/>" min="1" required><br>

        <label for="data">Data da Viagem:</label>
        <input type="date" id="data" name="data" value="<c:out value="${viagem.data}"/>" required><br>
        <%-- Display custo as read-only. It's calculated in the model. --%>
        <label for="custo">Custo da Viagem (R$):</label>
        <input type="text" id="custo" name="custo" value="<c:out value="${String.format('%.2f', viagem.custo)}"/>" readonly class="read-only"><br>


        <input type="submit" value="Atualizar Viagem">
    </form>

    <a href="ViagemServlet" class="back-link">Voltar para a lista de viagens</a>
</body>
</html>