<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="post" action="exemplo7.jsp">
        Nome: <input type="text" name="nome">
        Preco: <input type="number" name="preco">
        <input type="submit">
    </form>
    <%
    String s1 = request.getParameter("nome");
    String s2 = request.getParameter("preco");

    if((s1 != null) && (s2 != null)){
        float num = Float.parseFloat(s2);
        out.println("<p>Nome: " + s1 + "<br>");
        out.println("<p>R$ " + num);
    }
    %>
</body>
</html>