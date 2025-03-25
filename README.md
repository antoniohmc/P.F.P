# 📌 Sistema de Gerenciamento de Jogadores e Matchmaking

## 📖 Sobre o Projeto
Este projeto é uma API desenvolvida em **Java Spring Boot** com **MongoDB** para o gerenciamento de jogadores, jogos e um sistema de matchmaking. Ele permite que usuários se registrem, sigam outros jogadores e encontrem usuários com interesses em jogos similares.

---

## 🚀 Funcionalidades

### 🎮 Gerenciamento de Jogadores
- Cadastro de novos jogadores com nome de usuário, email, senha, país e plataforma utilizada.
- Autenticação de jogadores com verificação de credenciais.
- Atualização e remoção de jogadores.
- Adição de jogos favoritos ao perfil do jogador.

### 🔗 Sistema de Seguidores (Follow)
- Seguir outros jogadores.
- Deixar de seguir jogadores.
- Listar jogadores seguidos por um usuário.

### 🕹️ Gerenciamento de Jogos
- Cadastro de novos jogos.
- Listagem de todos os jogos disponíveis.

### 🤝 Matchmaking
- Buscar jogadores que têm um jogo específico como favorito.

---

## 🛠️ Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.3.5** (Spring Data, Spring Web)
- **MongoDB** (Banco de dados NoSQL)
- **Lombok** (Para reduzir boilerplate code)
- **SpringDoc OpenAPI** (Para documentação da API)
- **Maven** (Gerenciador de dependências)

---

## 📂 Estrutura do Projeto

```
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
```

---

## 🔧 Configuração e Execução
### 📥 Pré-requisitos
- **Java 21**
- **MongoDB** instalado e rodando localmente
- **Maven** instalado
- **Lombok** configurado na IDE (Necessário para compilar corretamente)

### ▶️ Passos para Rodar o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/tela-login.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd tela-login
   ```
3. Configure o banco de dados MongoDB no arquivo `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/tela_login
   ```
4. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

---

## 📌 Endpoints da API

### 📌 Jogadores
- **Cadastrar jogador:** `POST /players`
- **Buscar jogador por username:** `GET /players/{username}`
- **Deletar jogador:** `DELETE /players/{id}`
- **Autenticar jogador:** `POST /players/auth`

### 📌 Seguidores
- **Seguir um jogador:** `POST /follow/{username}`
- **Deixar de seguir:** `DELETE /follow/{username}`
- **Listar seguidores:** `GET /follow/{username}`

### 📌 Jogos
- **Cadastrar jogo:** `POST /games`
- **Listar jogos:** `GET /games`

### 📌 Matchmaking
- **Buscar jogadores por jogo favorito:** `GET /matchmaking/{gameName}`

---

## 📜 Licença
Este projeto é de código aberto e pode ser modificado conforme necessário.

---

## 👨‍💻 Autor
**[Antônio Campos]** - Desenvolvedor Backend

