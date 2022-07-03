# **Teste Java - OTTECH**

*A proposta do desafio é a criação de um CRUD com relacionamento de entidades (Métodos encadeados).**

# Tecnologias

-  Maven
-   Java 11
-   Spring Boot 2.7.0
-   H2 Database
-   Swagger
-   Lombok


## URLS

-   Default port : http://localhost:8080/
-   H2 port : http://localhost:8080/h2-console
-   Swagger port :  http://localhost:8080/swagger-ui.html


## Constraints
- O CNPJ é único;
- O nome do cliente precisa ter no min = 5 caracteres e no max = 50;
- O registro de uma proposta só é realizado se o cliente e o projeto co-existirem;
- Um projeto projeto não pode ser registrado duas vezes com o mesmo nome;
- Os atributos não podem ser em branco; O tratamento de exceptions retornará um 404 com o campo do erro.   

## EndPoints

 **Cliente**
- **POST** /api/clientes/registrar -> Registra um novo cliente;
- **GET** /api/clientes/ -> Retorna todos os clientes, proposta e projeto e tem opção de filtro por parâmetro.
- **PUT** /api/clientes//atualizar/{id} -> Atualiza um cliente pelo id.
- **DELETE** /api/clientes/{id} -> Deleta uma cliente por pelo Id;
 
 **Proposta**
- **POST** /api/propostas/registrar -> Registra uma nova proposta;
- **GET** /api/propostas/ -> Retorna todas as propostas e tem opção de filtro por parâmetro.
- **DELETE** /api/propostas/{id} -> Deleta uma proposta pelo id;

 **Projeto**
- **POST** /api/projetos/cadastrar -> Registra um novo projeto;
- **GET** /api/projetos/ -> Retorna todos as projetos e tem opção de filtro por parâmetro.
- **PUT** /api/projetos//atualizar/{id} -> Atualiza um cliente pelo id.
- **DELETE** /api/projetos/{id} -> Deleta um projeto pelo id;


## Models
```json
Cliente {
  "id": "Long"
  "nomeCliente": "String";
}
```
```json
Cnpj {
"Cnpj":"String"
}
```
```json
Projeto {
"id": "Long",
"nomeProjeto": "Atring",
"descricaoProjeto": "String"
}
```
```json
Proposta {
"id": Long,
"data": "LocalDate",
"status": "ENUM",
"cliente_id": "Long",
"projeto_id": "Long"
}
```

