# 🚀 Fórum Hub - Alura Challenge

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Java](https://img.shields.io/badge/java-21-blue)
![Spring Boot](https://img.shields.io/badge/spring%20boot-3.0-green)
![Licença](https://img.shields.io/badge/licença-MIT-lightgrey)

## 📖 Sobre o Projeto

O **Fórum Hub** é uma API RESTful desenvolvida como parte do Challenge de Back-End da Alura Oracle Next Education (ONE).  
O objetivo é criar o back-end de um fórum de discussão, permitindo que usuários criem, leiam, atualizem e excluam tópicos, com autenticação segura baseada em tokens JWT.

Este projeto demonstra a aplicação de conceitos essenciais do desenvolvimento back-end com Java e Spring Boot, incluindo:

- Criação de uma API REST
- Validações e persistência de dados
- Segurança com autenticação stateless via JWT
- Organização de código em camadas (DTO, Controller, Domain, Repository)

---

## ✨ Funcionalidades Principais

- 🔐 **Autenticação Segura**: Login com geração de token JWT
- 👤 **Controle de Acesso**: Endpoints protegidos para usuários autenticados
- 📝 **CRUD de Tópicos**:
  - Criar novos tópicos
  - Listar todos os tópicos ou buscar por ID
  - Atualizar tópicos existentes
  - Excluir tópicos logicamente (desativar)
- ✅ **Validações**: Evita duplicações e garante integridade dos dados
- 🗃️ **Persistência**: Spring Data JPA com MySQL

---

## 🛠️ Tecnologias Utilizadas

| Ferramenta        | Descrição                                      |
|-------------------|------------------------------------------------|
| Java 24           | Linguagem principal                            |
| Spring Boot 3     | Framework para aplicações Java                 |
| Spring Security   | Autenticação e autorização                     |
| JPA / Hibernate   | Persistência e ORM                             |
| Maven             | Gerenciador de dependências                    |
| Lombok            | Redução de código repetitivo                   |
| MySQL             | Banco de dados relacional                      |
| JWT (Java JWT)    | Geração e validação de tokens                  |

---

## 🚀 Como Executar o Projeto

### 🔧 Pré-requisitos

- Java 21+
- Maven 4+
- MySQL instalado e rodando
- Git
- Postman ou Insomnia para testar a API

### 📦 Passos

1. **Clone o repositório**:
 ```bash
git clone https://github.com/MariaAlineMees/forum-hub.git
cd forum-hub
```

3. **Configure o banco de dados**:
- Crie um banco chamado forumhub_api no MySQL
- Verifique se o usuário e senha estão corretos no arquivo:
src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub_api
spring.datasource.username=root
spring.datasource.password=root


4. **Execute a aplicação**:
 mvn spring-boot:run

A API estará disponível em:
📍 http://localhost:8080

## 📄 Endpoints da API

| Método HTTP | Endpoint         | Descrição                  | Autenticação | Corpo da Requisição (JSON)                          |
|-------------|------------------|----------------------------|--------------|-----------------------------------------------------|
| POST        | `/login`         | Autentica e retorna token JWT | ❌ Não       | `{ "email": "seu-email", "senha": "sua-senha" }`    |
| GET         | `/topicos`       | Lista todos os tópicos     | ✅ Sim       | N/A                                                 |
| GET         | `/topicos/{id}`  | Busca tópico por ID        | ✅ Sim       | N/A                                                 |
| POST        | `/topicos`       | Cria novo tópico           | ✅ Sim       | `{ "titulo": "...", "mensagem": "...", "curso": "..." }` |
| PUT         | `/topicos/{id}`  | Atualiza tópico existente  | ✅ Sim       | `{ "titulo": "...", "mensagem": "..." }`           |
| DELETE      | `/topicos/{id}`  | Exclui (desativa) tópico   | ✅ Sim       | N/A                                                 |

👩‍💻 Autora:
Maria Aline Mees


📜 Licença:
Este projeto está sob a licença MIT.
Consulte o arquivo LICENSE para mais detalhes.





