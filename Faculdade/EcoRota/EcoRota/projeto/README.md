# EcoRota - Sistema de Gerenciamento de Roteiros

## Funcionalidades Implementadas

### 1. Sistema de Login com Cores Personalizadas

- **Cadastro de Usuário**: Os usuários podem se cadastrar escolhendo cores de fundo e fonte personalizadas
- **Login**: Após o login, as cores escolhidas pelo usuário são aplicadas em todo o site
- **Persistência**: As cores são salvas no banco de dados e aplicadas via sessão

### 2. Sistema JSON para Motoristas

- **Formulário JSON**: O formulário cria um objeto JSON e envia para o servlet
- **Listagem com Busca**: Interface similar ao motoristafrm.jsp com:
  - Campo de busca por nome
  - Campo de busca por matrícula
  - Campo de busca por idade
  - Botões de editar e excluir para cada motorista
- **API REST**: Endpoint para salvar motoristas via JSON

## Como Usar

### 1. Configuração do Banco de Dados

1. Execute o script `script_banco.sql` no seu MySQL
2. Verifique se as credenciais no `ConnectionFactory.java` estão corretas

### 2. Compilação e Execução

1. Compile o projeto: `mvn clean compile`
2. Execute: `mvn tomcat7:run`
3. Acesse: `http://localhost:8080/projeto/`

### 3. Fluxo de Uso

#### Cadastro e Login

1. Acesse `cadastro.jsp` para criar uma conta
2. Escolha suas cores preferidas (fundo e fonte)
3. Faça login em `login.jsp`
4. As cores serão aplicadas automaticamente em todas as páginas

#### Motoristas JSON

1. Acesse `motoristajson.jsp`
2. Use o formulário para cadastrar motoristas (dados enviados como JSON)
3. Use os campos de busca para filtrar motoristas
4. Use os botões de editar/excluir para gerenciar motoristas

## Estrutura do Projeto

```
projeto/
├── src/main/java/br/cefet/
│   ├── controller/
│   │   ├── AuthFilter.java          # Filtro para aplicar cores do usuário
│   │   ├── CadastroServlet.java     # Servlet de cadastro
│   │   ├── LoginServlet.java        # Servlet de login
│   │   └── MotoristaServlet.java    # Servlet de motoristas (JSON)
│   ├── dao/
│   │   ├── ConnectionFactory.java   # Conexão com banco
│   │   ├── UsuarioDao.java          # DAO de usuários
│   │   └── MotoristaDao.java        # DAO de motoristas
│   └── model/
│       ├── Usuario.java             # Modelo de usuário
│       └── Motorista.java           # Modelo de motorista
├── src/main/webapp/
│   ├── cadastro.jsp                 # Página de cadastro
│   ├── login.jsp                    # Página de login
│   ├── menu.jsp                     # Menu principal
│   ├── motoristafrm.jsp             # Formulário tradicional
│   └── motoristajson.jsp            # Formulário JSON
└── script_banco.sql                 # Script do banco de dados
```

## Tecnologias Utilizadas

- **Backend**: Java Servlet, JSP, JDBC
- **Frontend**: HTML, CSS, JavaScript, Fetch API
- **Banco de Dados**: MySQL
- **Build**: Maven
- **JSON**: Gson (Google)

## Usuário de Teste

- **Usuário**: admin
- **Senha**: admin
- **Cores**: Fundo verde claro (#e8f5e8), Fonte verde escuro (#2c5e2c)
