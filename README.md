# Desafio Java API - Bootcamp DIO/Avanade

Este é o repositório do projeto desenvolvido durante o **Bootcamp Avanade** da **DIO (Digital Innovation One)**.


## 🎯 Desafio
O objetivo deste desafio foi aplicar os conhecimentos adquiridos no curso para construir uma API REST a partir do modelo de um APP do Banco Santander.
<p align="center">
  <img src="https://github.com/ElizabethTerumi/dio-2025/blob/main/img/APP%20Santander.png?raw=true" width="200" />
</p>

## 🚀 Tecnologias 

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **OpenAPI (Swagger)**
- **Railway**

## ⭐ Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```

## ⭐ Spring  initializr - Criação e Importação do Projeto
### Acesso: start.spring.io
![Projeto](https://github.com/ElizabethTerumi/dio-2025/blob/main/img/Spring%20initializr.jpg?raw=true))

## ⭐ H2 - Interface web com o banco de dados H2
### Tela Login Acesso: localhost:8080/h2-console
<img src="https://github.com/ElizabethTerumi/dio-2025/blob/main/img/H2%20login.jpg?raw=true" width="auto" height="300" />

## ⭐ H2 Tela Principal 
<img src="https://github.com/ElizabethTerumi/dio-2025/blob/main/img/H2%20Principal.jpg?raw=true" width="auto" height="400" />


## ⭐ Swagger - Interface Swagger UI no projeto Spring Boot 
### Acesso: localhost:8080/swagger-ui.html 
<img src="https://github.com/ElizabethTerumi/dio-2025/blob/main/img/Tela%20Swagger.jpg?raw=true" width="auto" height="300" />


## 🧡 Deploy - Railway
<img src="https://github.com/ElizabethTerumi/dio-2025/blob/main/img/Deploy%20Railway.png??raw=true" width="auto" height="400" />



