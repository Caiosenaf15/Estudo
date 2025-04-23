<!DOCTYPE html>
<html lang="pt- br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        float num = -21;
        String posNeg;
        String imparPar;
        if(num < 0){
            posNeg = "negativo";
        } else {
            posNeg = "positivo";
        }
        if(num % 2 == 0){
            imparPar = "par";
        } else {
            imparPar = "impar";
        }

        out.println("<p>O numero " + num + " e " + imparPar + " e " + posNeg);

    %>
</body>
</html>