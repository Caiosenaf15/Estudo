<!DOCTYPE html>
<html lang="pt- br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        float num = 4;
        float var = 0;
        for (float i = num; i >= 0; i--){
            out.println(i + "<br>");
        }
        out.println("<br>");
        while (var <= num){
            out.println(var + "<br>");
            var++;
        }
    %>
</body>
</html>