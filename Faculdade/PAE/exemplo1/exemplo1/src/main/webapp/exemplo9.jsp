<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="exemplo9.jsp" method="GET">
        <label for="nome">Nome</label> <input type="text" name="nome" id="nome">
        <label for="salario">Salario</label> <input type="number" name="salario" id="salario">
        <label for="data">Data de Admissao</label> <input type="date" name="data" id="data">
        <label for="estado">Estado</label> <input type="radio" name="estado" id="estado">
        <input type="submit">
    </form>

    <%
        String nome = request.getParameter("nome");
        String salario = request.getParameter("salario");
        String inputdata = request.getParameter("data");
        java.time.LocalDate localDate = java.time.LocalDate.parse(inputdata);
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        java.time.format.DateTimeFormatter outputFormatter =
        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        out.println("Data inserida: " + inputdata + "<br>");
        out.println("Data convertida (java.sql.Date): " + sqlDate + "<br>");
        out.println("Data convertida (formato dd/MM/yyyy): " + localDate.format(outputFormatter)+ "<br>");
    %>
    %>
</body>
</html>