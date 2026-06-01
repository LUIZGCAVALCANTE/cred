# API de Clientes

## Criar Cliente

**POST**

```http
POST /clients
```

URL:

```text
http://localhost:8001/clients
```

---

## Listar Todos os Clientes

**GET**

```http
GET /clients/all
```

URL:

```text
http://localhost:8001/clients/all
```

---

## Buscar Cliente por ID

**GET**

```http
GET /clients/buscar/{id}
```

Exemplo:

```text
http://localhost:8001/clients/buscar/1
```

---

## Atualizar Cliente

**PUT**

```http
PUT /clients/att/{id}
```

Exemplo:

```text
http://localhost:8001/clients/att/1
```

---

## Deletar Cliente

**DELETE**

```http
DELETE /clients/del/{id}
```

Exemplo:

```text
http://localhost:8001/clients/del/1
```
