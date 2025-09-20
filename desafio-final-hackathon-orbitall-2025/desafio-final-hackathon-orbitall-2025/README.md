# 🚀 Desafio Final - Hackaton Orbitall 2025
API de Gestão de **Clientes** e **Transações** desenvolvida em Java + Spring Boot.


---

## 📦 Tecnologias
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Lombok

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/NataliaSouzaCavalcante/Hackathon_2025.git
cd Hackathon_2025
```

### 2. Compilar e instalar dependências
```bash
mvn clean install
```

### 3. Executar a aplicação
```bash
mvn spring-boot:run
```

> A aplicação ficará disponível em:  
👉 `http://localhost:8080`

---

## 📚 Endpoints

### Clientes `/customers`
- `POST /customers` → Cadastrar cliente
- `GET /customers/{id}` → Buscar cliente por ID
- `PUT /customers/{id}` → Atualizar cliente
- `DELETE /customers/{id}` → Remover cliente
- `GET /customers` → Listar clientes ativos

### Transações `/transactions`
- `POST /transactions` → Criar transação vinculada a cliente
- `GET /transactions?customerId={id}` → Listar transações de um cliente

---

## 📖 Exemplos de uso (JSON)

### Criar Cliente
```json
POST /customers
{
  "fullName": "João Silva",
  "email": "joao@email.com",
  "phone": "11999999999"
}
```

### Criar Transação
```json
POST /transactions
{
  "customerId": "c98a83b7-63a7-4fa2-9fd6-123456789abc",
  "amount": 250.00,
  "cardType": "CREDITO"
}
```

---

## 🛠 Dicas importantes
- Habilite o **plugin Lombok** no IntelliJ.
- Banco de dados **H2 em memória**: acesse em `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:testdb`
    - User: `sa` / Password: vazio

---

## ✨ Autores
Projeto desenvolvido como parte do **Hackaton Orbitall 2025** organizado pela [Stefanini](https://stefanini.com/).  
