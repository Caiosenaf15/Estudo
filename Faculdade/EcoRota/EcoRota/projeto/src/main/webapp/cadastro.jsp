<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <title>Cadastro de Usuário</title>
    <style>
      body {
        font-family: "Segoe UI", sans-serif;
        background-color: #f5fff9;
        color: #333;
      }
      .cadastro-container {
        max-width: 400px;
        margin: 80px auto;
        background: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
      }
      h2 {
        color: #36a96d;
        text-align: center;
      }
      label {
        display: block;
        margin-top: 15px;
      }
      input[type="text"],
      input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 6px;
      }
      button {
        background: #36a96d;
        color: #fff;
        border: none;
        padding: 12px 20px;
        border-radius: 6px;
        cursor: pointer;
        width: 100%;
        margin-top: 20px;
      }
      button:hover {
        background: #2f8e5d;
      }
    </style>
    <script>
      function salvarPreferencias() {
        document.cookie =
          "corFundo=" + document.getElementById("corFundo").value + "; path=/";
        document.cookie =
          "corFonte=" + document.getElementById("corFonte").value + "; path=/";
      }
    </script>
  </head>
  <body>
    <div class="cadastro-container">
      <h2>Cadastro de Usuário</h2>
      <form
        action="CadastroServlet"
        method="post"
        onsubmit="salvarPreferencias()"
      >
        <label for="usuario">Usuário:</label>
        <input type="text" id="usuario" name="usuario" required />
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required />
        <label for="corFundo">Cor de fundo:</label>
        <input type="color" id="corFundo" name="corFundo" value="#f5fff9" />
        <label for="corFonte">Cor da fonte:</label>
        <input type="color" id="corFonte" name="corFonte" value="#333333" />
        <button type="submit">Cadastrar</button>
      </form>
      <div style="text-align: center; margin-top: 20px">
        <a href="login.jsp">Já tem conta? Entrar</a>
      </div>
    </div>
  </body>
</html>
