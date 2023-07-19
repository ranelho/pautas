## Api de Gestão de Pautas

### ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``Spring Boot 3.1.1``
- ``Maven 3.9.1``
- ``JPA``
- ``Lombok``
- ``PostgreSQL``
- ``InteliJ IDEA``
- ``Swagger springdoc 2.0.3``
- ``Postman - para teste da APi local``
- ``Git - para versionamento``
- ``GitHub``

### Ajustes e melhorias

Validação de votos em assembleias:

|Associado | Pauta        |
| --- | --- |
| Cadastro | Cadastro     |
| Lista Todos | Votacao      |
| Atualiza Status  | Pauta por Id |
| Busca por CPF  | Resultado    |

### Swagger Local
```
http://localhost:8080/act/api/public/swagger-ui/index.html
```
  <img src="associados.png" width=300>  <img src="pauta.png" width=300>

### ER Diagrama BD
<img src="database.png" width=250>

### Pull Request's
```
https://github.com/ranelho/act/pull/1

https://github.com/ranelho/act/pull/2
```


### Clone Projeto
```
git remote add origin https://github.com/ranelho/act.git
```
## Trechos de código
### application.yml 

```
# profile via variável de ambiente -> ex: para banco em produção SPRING_PROFILES_ACTIVE = prod,
# para banco de teste SPRING_PROFILES_ACTIVE = dev

spring:
  profiles:
    active: ${SPRING_PROFILES_ACTIVE}
server:
  servlet:
    context-path: /act/api

#configuração swagger
springdoc:
  swagger-ui:
    path: /public/swagger
```

### application-prod.yml
```
# Configuração para deploy em produção
# DB_HOST_PROD url para o banco ex: jdbc:postgresql://localhost:5432/act
# DB_USERNAME_PROD usuario do banco
# DB_PASSWORD_PROD senha do banco

spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: ${DB_HOST_PROD}
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
### application-dev.yml

```
# Configuração para acesso ao banco de dados de testes local

spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/act
    username: #usuario local
    password: #senha local
  jpa:
    generate-ddl: true
    properties:
      hibernate:
        ddl-auto: update
        show_sql: true
        format_sql: true
```

### Validações
```
// 400 - Bad Request
{    
    "message": "Horário de votação ainda não começou"   
}
{    
    "cpf": "CPF inválido"                               
}

// 404 - Not Found
{    
    "message": "Pauta não encontrada!"                  
}
{
    "cpf": "deve corresponder a \"(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)\""
}

```
### Resultado
```
// {{baseUrl}}/v1/pautas/resultado/:idPauta

{  
    "pauta": "LEI 123",
    "dataPauta": "2023-07-15 14:16",
    "votantes": [
        {
            "associado": "RAFAELA SANDRA LAVÍNIA DRUMOND"
            "voto": "NAO",
        },
        {
            "associado": "GIOVANNI AUGUSTO PIRES"
            "voto": "SIM",
        },
        {
            "associado": "JOSÉ LUAN DAS NEVES"
            "voto": "SIM",
        }
    ],
    "votosSim": 2,
    "votosNao": 1,
    "vencedor": "SIM"
}
```
[⬆ Voltar ao topo](https://github.com/ranelho/act)<br>