# Sistema de controle de matriculas de Auto Escola

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)

## ✔️ Técnicas e tecnologias utilizadas

- ``Java``
- ``Spring Boot``
- ``Maven``
- ``JPA``
- ``Lombok``
- ``PostgreSQL``
- ``InteliJ IDEA``
- ``Swagger``
- ``Postman``
- ``DBeaver``
- ``Git``
- ``GitHub``

### Ajustes e melhorias

Validação de votos em assembléias:

- [X] Empresa

# Banco de Dados
<img src="Banco.png" width=650><br><sub>Banco de Dados</sub>

## Trechos de código

### Swagger
http://localhost:8080/act/api/public/swagger-ui/index.html#/

### Clone Projeto
git remote add origin https://github.com/ranelho/act.git

### application.yml

```
spring:
  profiles:
    active: ${SPRING_PROFILES_ACTIVE}
server:
  servlet:
    context-path: /act/api

springdoc:
  swagger-ui:
    path: /public/swagger
```

### application-prod.yml
```
spring:
datasource:
  driverClassName: org.postgresql.Driver
  url: jdbc:postgresql://${DB_HOST_PROD}:${DB_PORT_PROD}/${DB_NAME_PROD}
  username: ${DB_USERNAME_PROD}
  password: ${DB_PASSWORD_PROD}
jpa:
  generate-ddl: true
  properties:
    hibernate:
      ddl-auto: update
      show_sql: true
      format_sql: true
```

# Autores

| [<img src="perfil2.jpg" width=115><br><sub>Ranelho Lacerda</sub>](https://github.com/ranelho) |
|:---------------------------------------------------------------------------------------------:|

[⬆ Voltar ao topo](https://github.com/ranelho/act)<br>