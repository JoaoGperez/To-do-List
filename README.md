
# 📝 To Do List API

API de gerenciamento de tarefas, desenvolvida em Java com Spring Boot. Permite listar, criar, concluir, editar e excluir tarefas. Este projeto foi desenvolvido com o objetivo de aprimorar minhas habilidades em Java e Spring Boot, explorando os conceitos de desenvolvimento de APIs RESTful, persistência de dados com JPA e boas práticas de arquitetura com separação de camadas (Controller, Service e Repository).

---

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Swagger/OpenAPI 3 (para documentação)
- Maven

---

## 📦 Funcionalidades

- Listar todas as tarefas
- Criar nova tarefa
- Marcar tarefa como concluída
- Editar tarefa
- Excluir tarefa

---

## ⚙️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/JoaoGperez/To-do-List
cd To-do-List
```
### 2. Rode o projeto com Maven
```bash
./mvnw spring-boot:run
```
A API estará disponível em: http://localhost:8080/api

---

## 🧪 Documentação da API
Acesse o Swagger UI para explorar os endpoints:
```bash
http://localhost:8080/api/swagger-ui.html
```
---

## 📌 Endpoints disponíveis
- `GET /task` – Lista todas as tarefas
- `POST /task` – Cria uma nova tarefa
- `PUT /task/{id}/complete` – Marca uma tarefa como concluída
- (Outros endpoints em desenvolvimento)
---

## 💾 Banco de Dados H2
Console: http://localhost:8080/api/h2-ui

- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (vazia)

---

## 🛠️ Requisitos

- Java 22 ou superior
- Maven 3.8+

---

## ✍️ Autor
Desenvolvido por João Gabriel Perez Monteiro
