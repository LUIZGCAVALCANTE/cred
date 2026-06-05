# API de Clientes

API REST desenvolvida com Spring Boot para gerenciamento de clientes.

## Base URL

```text
http://localhost:8001
```

---

## Criar Cliente

**POST**

```http
POST /clients
```

URL:

```text
http://localhost:8001/clients
```

Exemplo de Body:

```json
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```

---

## Listar Clientes (Paginado)

**GET**

```http
GET /clients?page=0&size=6&sort=name
```

Exemplo:

```text
http://localhost:8001/clients?page=0&size=6&sort=name
```

---

## Buscar Cliente por ID

**GET**

```http
GET /clients/{id}
```

Exemplo:

```text
http://localhost:8001/clients/1
```

---

## Atualizar Cliente

**PUT**

```http
PUT /clients/{id}
```

Exemplo:

```text
http://localhost:8001/clients/1
```

Exemplo de Body:

```json
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```

---

## Deletar Cliente

**DELETE**

```http
DELETE /clients/{id}
```

Exemplo:

```text
http://localhost:8001/clients/1
```

---

## Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven
* Bean Validation

---

## Tratamento de Erros

A API possui tratamento para:

* 404 Not Found (cliente não encontrado)
* 422 Unprocessable Entity (erros de validação)
* 400 Bad Request (violação de integridade dos dados)

---

## Validações

* Nome não pode ser vazio
* CPF deve possuir 11 caracteres
* Data de nascimento não pode ser futura
