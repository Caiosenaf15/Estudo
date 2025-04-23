<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="get" action="ServletExemplo10">
        Nome: <input type="text" name="nome" value="${n}">
        Salario: <input type="number" name="salario" value="${salario}">
        Admissao: <input type="date" name="data" value="${data}">
        Estado: <input type="radio" name="uf" value="${uf}">
        <input type="submit">
    </form>

   
        <h2>Dados Recebidos</h2>
        <p><strong>Nome:</strong> ${n}</p>
        <p><strong>Salário com aumento:</strong> ${salario}</p>
        <p><strong>Data de Admissão:</strong> ${data}</p>
        <p><strong>Estado:</strong> ${uf}</p>;

</body>
</html>