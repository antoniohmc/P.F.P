📌 Sistema de Gerenciamento de Jogadores e Matchmaking
📖 Sobre o Projeto
Este projeto é uma API desenvolvida em Java Spring Boot com MongoDB para o gerenciamento de jogadores, jogos e um sistema de matchmaking. Ele permite que usuários se registrem, sigam outros jogadores e encontrem usuários com interesses em jogos similares.

🚀 Funcionalidades
🎮 Gerenciamento de Jogadores
Cadastro de novos jogadores com nome de usuário, email, senha, país e plataforma utilizada.

Autenticação de jogadores com verificação de credenciais.

Atualização e remoção de jogadores.

Adição de jogos favoritos ao perfil do jogador.

🔗 Sistema de Seguidores (Follow)
Seguir outros jogadores.

Deixar de seguir jogadores.

Listar jogadores seguidos por um usuário.

🕹️ Gerenciamento de Jogos
Cadastro de novos jogos.

Listagem de todos os jogos disponíveis.

🤝 Matchmaking
Buscar jogadores que têm um jogo específico como favorito.

🛠️ Tecnologias Utilizadas
Java 21

Spring Boot 3.3.5 (Spring Data, Spring Web)

MongoDB (Banco de dados NoSQL)

Lombok (Para reduzir boilerplate code)

SpringDoc OpenAPI (Para documentação da API)

Gradle (Gerenciador de dependências)

📂 Estrutura do Projeto
bash
Copiar
Editar
📦 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 com.tcc
 ┃ ┃ ┃ ┣ 📂 controller  # Controladores da API
 ┃ ┃ ┃ ┣ 📂 model       # Modelos de dados
 ┃ ┃ ┃ ┣ 📂 repository  # Interfaces de acesso ao banco
 ┃ ┃ ┃ ┣ 📂 service     # Lógica de negócios
 ┃ ┃ ┃ ┣ 📂 exceptions  # Exceções personalizadas
 ┃ ┃ ┃ ┗ 📜 Application.java  # Classe principal
 ┃ ┗ 📂 resources
 ┃ ┃ ┗ 📜 application.properties  # Configurações do banco de dados
🔧 Configuração e Execução
📥 Pré-requisitos
Java 21

MongoDB instalado e rodando localmente

Gradle instalado

Lombok configurado na IDE (Necessário para compilar corretamente)

▶️ Passos para Rodar o Projeto
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/tela-login.git
Acesse a pasta do projeto:

bash
Copiar
Editar
cd tela-login
Configure o banco de dados MongoDB no arquivo application.properties:

properties
Copiar
Editar
spring.data.mongodb.uri=mongodb://localhost:27017/tela_login
Compile e execute o projeto:

bash
Copiar
Editar
./gradlew bootRun
📌 Endpoints da API
📌 Jogadores
Cadastrar jogador:
POST /player/cadastrar
Corpo: { "username": "nome", "password": "senha", "email": "email", "country": "país", "platform": "plataforma" }
Descrição: Cadastra um novo jogador.

Buscar jogador por username:
GET /player/username/{username}
Descrição: Busca um jogador pelo seu nome de usuário.

Login de jogador:
GET /player/login
Parâmetros: username, password
Descrição: Realiza o login de um jogador com as credenciais fornecidas.

Deletar jogador:
DELETE /player/{id}
Descrição: Deleta um jogador pelo seu ID.

Deletar todos os jogadores:
DELETE /player/delete-all
Descrição: Exclui todos os jogadores do banco de dados.

Atualizar jogador:
PUT /player/{username}
Corpo: { "username": "novo_nome", "password": "nova_senha", "email": "novo_email", "country": "novo_país", "platform": "nova_plataforma" }
Descrição: Atualiza as informações de um jogador, identificando-o pelo username.

Adicionar jogo à lista de favoritos de um jogador:
POST /player/{username}/addNewGame
Parâmetros: gameName
Descrição: Adiciona um jogo à lista de favoritos de um jogador.

Listar todos os jogadores:
GET /player
Descrição: Lista todos os jogadores cadastrados no sistema.

📌 Seguidores
Seguir um jogador:
POST /follow/{username}
Descrição: Segue um jogador específico.

Deixar de seguir:
DELETE /follow/{username}
Descrição: Deixa de seguir um jogador específico.

Listar seguidores:
GET /follow/{username}
Descrição: Lista todos os jogadores seguidos por um jogador.

📌 Jogos
Cadastrar jogo:
POST /games
Descrição: Cadastra um novo jogo no sistema.

Listar jogos:
GET /games
Descrição: Lista todos os jogos disponíveis no sistema.

📌 Matchmaking
Buscar jogadores por jogo favorito:
GET /matchmaking/{gameName}
Descrição: Busca jogadores que têm o jogo especificado como favorito.

📜 Licença
Este projeto é de código aberto e pode ser modificado conforme necessário.

👨‍💻 Autor
[Antônio Campos] - Desenvolvedor Backend

📑 Documentação Completa da API
Para acessar a documentação completa da API, acesse o Swagger da API:
http://localhost:8080/swagger-ui/index.html#/
(O projeto deve estar sendo executado)

