<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <title>Motoristas JSON</title>
    <style>
      body {
        font-family: "Segoe UI", sans-serif;
        background-color: #f5fff9;
        margin: 0;
        padding: 100px 20px 40px;
        color: #333;
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      header {
        background-color: #36a96d;
        padding: 15px 20px;
        color: white;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        z-index: 1000;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      }
      nav {
        display: flex;
        gap: 20px;
        justify-content: center;
        align-items: center;
      }
      nav a {
        color: white !important;
        text-decoration: none;
        font-size: 16px;
        font-weight: 500;
        background: #36a96d;
        padding: 10px 18px;
        border-radius: 8px;
        transition: background 0.2s;
      }
      nav a:hover {
        background: #2f8e5d;
        color: #fff !important;
      }
      header,
      nav,
      footer {
        color: inherit !important;
      }
      .container {
        width: 100%;
        max-width: 800px;
        background: #e6f9ee;
        border-radius: 16px;
        box-shadow: 0 2px 12px rgba(0,0,0,0.06);
        padding: 32px 24px 24px 24px;
        margin-top: 40px;
      }
      h2 {
        color: #2c7a52;
        margin-top: 0;
        font-size: 28px;
        text-align: center;
        font-weight: 700;
      }
      form {
        background-color: #ffffff;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        margin-bottom: 40px;
      }
      form label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
        color: #444;
      }
      form input[type="text"],
      form input[type="number"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
      }
      form input[type="submit"],
      button {
        background-color: #36a96d;
        color: white;
        border: none;
        padding: 12px 24px;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
        font-weight: 500;
        box-shadow: 0 2px 8px rgba(0,0,0,0.07);
        transition: background 0.2s;
      }
      form input[type="submit"]:hover,
      button:hover {
        background-color: #2f8e5d;
      }
      .message {
        padding: 12px;
        border-radius: 5px;
        margin-bottom: 20px;
        font-weight: bold;
        text-align: center;
      }
      .success {
        background-color: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
      }
      .error {
        background-color: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
      }
      .center-link {
        display: block;
        text-align: center;
        margin-top: 10px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        margin-top: 20px;
      }

      table th,
      table td {
        padding: 14px;
        text-align: left;
        border-bottom: 1px solid #eee;
      }

      table th {
        background-color: #e8f5ec;
        color: #2c7a52;
        font-size: 18px;
      }

      table tbody tr:hover {
        background-color: #f1fff5;
      }

      .action-links a {
        margin-right: 12px;
        font-weight: bold;
        color: #2d8659;
        text-decoration: none;
      }

      .action-links a:hover {
        color: #1b5e3d;
        text-decoration: underline;
      }

      .busca-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        margin-bottom: 20px;
        display: flex;
        flex-wrap: wrap;
        gap: 12px;
        justify-content: center;
        align-items: center;
      }

      .busca-container input {
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
        padding: 8px 12px;
      }

      .busca-container button {
        background-color: #36a96d;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 8px;
        cursor: pointer;
        font-size: 15px;
        font-weight: 500;
        margin-left: 0;
        box-shadow: 0 2px 8px rgba(0,0,0,0.07);
        transition: background 0.2s;
      }

      .busca-container button:hover {
        background-color: #2f8e5d;
      }
    </style>
  </head>
  <body>
    <header>
      <nav>
        <a href="motoristafrm.jsp">Motoristas</a>
        <a href="trajetofrm.jsp">Trajetos</a>
        <a href="viagemfrm.jsp">Viagens</a>
      </nav>
    </header>
    <main class="container">
      <h2>Cadastro de Motorista via JSON</h2>
      <form id="jsonForm">
        <label for="json-nome">Nome:</label>
        <input type="text" name="nome" id="json-nome" required />
        <label for="json-idade">Idade:</label>
        <input type="number" name="idade" id="json-idade" required />
        <label for="json-matricula">Matrícula:</label>
        <input type="text" name="matricula" id="json-matricula" required />
        <button type="submit">Salvar via JSON</button>
      </form>

      <h2>Lista de Motoristas</h2>

      <!-- Campo de busca -->
      <div class="busca-container">
        <input
          type="text"
          id="buscaNome"
          placeholder="Buscar por nome..."
          style="width: 200px; padding: 8px; margin-right: 10px"
        />
        <input
          type="text"
          id="buscaMatricula"
          placeholder="Buscar por matrícula..."
          style="width: 200px; padding: 8px; margin-right: 10px"
        />
        <input
          type="number"
          id="buscaIdade"
          placeholder="Buscar por idade..."
          style="width: 150px; padding: 8px; margin-right: 10px"
        />
        <button onclick="buscarMotoristas()">Buscar</button>
        <button onclick="listarTodos()">Limpar</button>
      </div>

      <table id="tabelaMotoristas" style="display: none">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Idade</th>
            <th>Matrícula</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody id="tabelaBody"></tbody>
      </table>

      <div id="mensagem" style="text-align: center; margin-top: 20px"></div>

      <a class="center-link" href="motoristafrm.jsp">Voltar para Motoristas</a>
    </main>

    <script>
      // Aplicar cores do usuário
      window.onload = function () {
        var corFundo = "${corFundo}";
        var corFonte = "${corFonte}";

        if (corFundo && corFundo.trim() !== "") {
          document.body.style.backgroundColor = corFundo;
        }
        if (corFonte && corFonte.trim() !== "") {
          document.body.style.color = corFonte;
        }

        // Carregar lista inicial
        listarTodos();
      };

      // Formulário JSON
      document
        .getElementById("jsonForm")
        .addEventListener("submit", function (e) {
          e.preventDefault();

          const formData = new FormData(this);
          const motorista = {
            nome: formData.get("nome"),
            idade: parseInt(formData.get("idade")),
            matricula: formData.get("matricula"),
          };

          fetch("MotoristaServlet", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(motorista),
          })
            .then((response) => response.json())
            .then((data) => {
              if (data.status === "ok") {
                alert("Motorista salvo com sucesso!");
                this.reset();
                listarTodos();
              } else {
                alert("Erro ao salvar motorista");
              }
            })
            .catch((error) => {
              console.error("Erro:", error);
              alert("Erro ao salvar motorista");
            });
        });

      // Função para listar todos os motoristas
      function listarTodos() {
        fetch("MotoristaServlet?format=json")
          .then((response) => response.json())
          .then((data) => {
            exibirMotoristas(data);
          })
          .catch((error) => {
            console.error("Erro:", error);
            document.getElementById("mensagem").innerHTML =
              "Erro ao carregar motoristas";
          });
      }

      // Função para buscar motoristas
      function buscarMotoristas() {
        const nome = document.getElementById("buscaNome").value;
        const matricula = document.getElementById("buscaMatricula").value;
        const idade = document.getElementById("buscaIdade").value;

        let url = "MotoristaServlet?format=json";
        const params = new URLSearchParams();

        if (nome) params.append("nome", nome);
        if (matricula) params.append("matricula", matricula);
        if (idade) params.append("idade", idade);

        if (params.toString()) {
          url += "&" + params.toString();
        }

        fetch(url)
          .then((response) => response.json())
          .then((data) => {
            exibirMotoristas(data);
          })
          .catch((error) => {
            console.error("Erro:", error);
            document.getElementById("mensagem").innerHTML =
              "Erro ao buscar motoristas";
          });
      }

      // Função para exibir motoristas na tabela
      function exibirMotoristas(motoristas) {
        const tabela = document.getElementById("tabelaMotoristas");
        const tbody = document.getElementById("tabelaBody");
        const mensagem = document.getElementById("mensagem");

        tbody.innerHTML = "";
        console.log(motoristas); // Debug: veja o que chega do backend

        if (!motoristas || motoristas.length === 0) {
          tabela.style.display = "none";
          mensagem.innerHTML = "Nenhum motorista encontrado";
          return;
        }

        tabela.style.display = "table";
        mensagem.innerHTML = "";

        motoristas.forEach((motorista) => {
          const id = motorista.id !== undefined ? motorista.id : '';
          const nome = motorista.nome !== undefined ? motorista.nome : '';
          const idade = motorista.idade !== undefined ? motorista.idade : '';
          const matricula = motorista.matricula !== undefined ? motorista.matricula : '';

          const row = document.createElement("tr");
          row.innerHTML =
            '<td>' + id + '</td>' +
            '<td>' + nome + '</td>' +
            '<td>' + idade + '</td>' +
            '<td>' + matricula + '</td>' +
            '<td>' +
              '<a href="MotoristaServlet?action=editar&id=' + id + '">Editar</a> ' +
              '<a href="MotoristaServlet?action=excluir&id=' + id + '" onclick="return confirm(\'Tem certeza que deseja excluir este motorista?\');">Excluir</a>' +
            '</td>';
          tbody.appendChild(row);
        });
      }
    </script>
  </body>
</html>
