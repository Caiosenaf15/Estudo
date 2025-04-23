<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="exemplo8.jsp" method="GET">
        <label for="nome">Nome: </label><br>
        <input type="text" id="nome" name="nome"><br>
        <label for="preco"> Preço:</label><br>
        <input type="number" id="preco" name="preco"placeholder="0.00" step="0.01" min="0"> <br>
        <input type="submit">
    </form>
    <%
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        out.println("Nome: " + nome + "<br>");
        out.println("Preco: " + preco);
    %>
</body>
</html>