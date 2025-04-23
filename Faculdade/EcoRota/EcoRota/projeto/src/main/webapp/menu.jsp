<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@
taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EcoRota</title>
    <style>
      body {
        margin: 0;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f3fdf6;
        color: #ffffff;
        display: flex;
        flex-direction: column;
        align-items: center;
      }

      header {
        background-color: #3ab36a;
        padding: 20px;
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
      }

      .logo-container {
        display: flex;
        align-items: center;
        gap: 15px;
      }

      .logo-container img {
        height: 60px;
        border-radius: 100%;
      }

      .logo-container h1 {
        margin: 0;
        font-size: 2.5rem;
      }

      header p {
        margin-top: 10px;
        font-size: 1rem;
        color: #ffffff;
      }

      nav {
        margin-top: 40px;
        display: flex;
        gap: 30px;
        flex-wrap: wrap;
        box-shadow: 1px 1px 2px solid rgba(0, 0, 0, 0.342);
      }

      nav a {
        text-decoration: none;
        background-color: #3ab36a;
        color: inherit !important;
        padding: 14px 26px;
        border-radius: 10px;
        font-size: 17px;
        transition: background-color 0.3s ease;
      }

      nav a:hover {
        background-color: #39993d;
      }

      footer {
        margin-top: 50px;
        color: #777;
        font-size: 14px;
      }

      header,
      nav,
      footer {
        color: inherit !important;
      }
    </style>
  </head>
  <body>
    <header>
      <div class="logo-container">
        <img src="imagens/ecorota-logo.png" alt="Logo EcoRota" />
        <h1>EcoRota</h1>
      </div>
      <p>Roteiros inteligentes com foco em sustentabilidade e economia</p>
    </header>

    <nav>
      <a href="trajetofrm.jsp">Trajeto</a>
      <a href="motoristafrm.jsp">Motorista</a>
      <a href="viagemfrm.jsp">Viagem</a>
      <a href="motoristajson.jsp">Motoristas JSON</a>
      <a href="login.jsp">Login</a>
    </nav>

    <footer>&copy; 2025 EcoRota. Todos os direitos reservados.</footer>

    <script>
      window.onload = function () {
        // Aplicar cores do usuário da sessão
        var corFundo = "${corFundo}";
        var corFonte = "${corFonte}";

        if (corFundo && corFundo.trim() !== "") {
          document.body.style.backgroundColor = corFundo;
        }
        if (corFonte && corFonte.trim() !== "") {
          document.body.style.color = corFonte;
        }

        // Fallback para cookies se não houver cores na sessão
        function getCookie(name) {
          let v = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
          return v ? v[2] : null;
        }

        if (!corFundo || corFundo.trim() === "") {
          var corFundoCookie = getCookie("corFundo");
          if (corFundoCookie)
            document.body.style.backgroundColor = corFundoCookie;
        }
        if (!corFonte || corFonte.trim() === "") {
          var corFonteCookie = getCookie("corFonte");
          if (corFonteCookie) document.body.style.color = corFonteCookie;
        }
      };
    </script>
  </body>
</html>
