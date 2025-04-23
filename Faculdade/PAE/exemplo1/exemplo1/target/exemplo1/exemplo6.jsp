<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem-Vindo!</title>
</head>
<body>
    <form method="post" action="exemplo6.jsp">
    Número 1: <input type=
    "number" name="n1">
    Número 2: <input type=
    "number" name="n2">
    <input type=
    "submit">
    </form>
    <%
    String s1 = request.getParameter("n1");
    String s2 = request.getParameter("n2");
    if ((s1!=null ) && (s2!=null)){
    float n1 = Float.parseFloat(s1);
    float n2 = Float.parseFloat(s2);
    float soma = n1 + n2;
    out.println("<p> A soma é " + soma);
    }
    %>
</body>
</html>