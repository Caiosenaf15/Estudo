<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <style>
      body {
        font-family: "Segoe UI", sans-serif;
        background-color: #f5fff9;
        color: #333;
      }
      .login-container {
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
  </head>
  <body>
    <div class="login-container">
      <h2>Login</h2>
      <form action="LoginServlet" method="post">
        <label for="usuario">Usuário:</label>
        <input type="text" id="usuario" name="usuario" required />
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required />
        <button type="submit">Entrar</button>
      </form>
      <c:if test="${not empty mensagemErro}">
        <div style="color: red; text-align: center; margin-top: 10px">
          ${mensagemErro}
        </div>
      </c:if>
      <div style="text-align: center; margin-top: 20px">
        <a href="cadastro.jsp">Criar nova conta</a>
      </div>
    </div>
  </body>
</html>
