<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem-Vindo!</title>
</head>
<body>
    <form action="exemplo5.jsp" method="GET">
    <input type="text" name="nome">
    <input type="submit"><br/>
    </form>
        <%
            String nome = request.getParameter("nome");
            out.print("Bem-vindo " + nome);
        %>
</body>
</html>