
# API de Reserva de Salas

Este projeto é uma API RESTful para gerenciar reservas de salas. Ela permite que os usuários façam CRUD (Create, Read, Update, Delete) em reservas, salas e usuários. Além disso, possui funcionalidades para verificar a disponibilidade de salas em horários específicos.

## Funcionalidades

### Reservas
- **Criar reservas**: Permite criar novas reservas de salas.
- **Consultar reservas**: Consultar reservas existentes.
- **Atualizar reservas**: Atualizar as informações de uma reserva.
- **Excluir reservas**: Excluir uma reserva por ID.
- **Verificar disponibilidade**: Checar se uma sala está disponível para um determinado horário, evitando conflitos de reservas.

### Salas
- **Criar salas**: Adicionar novas salas ao sistema.
- **Consultar salas**: Consultar detalhes de uma sala específica por ID.
- **Atualizar salas**: Atualizar as informações de uma sala existente.
- **Excluir salas**: Remover uma sala do sistema.

### Usuários
- **Criar usuários**: Adicionar novos usuários ao sistema.
- **Consultar usuários**: Consultar informações de um usuário específico por ID.
- **Atualizar usuários**: Atualizar os dados de um usuário.
- **Excluir usuários**: Remover um usuário do sistema.

## Tecnologias Utilizadas

- **Java** (Spring Boot)
- **H2 Database** (Banco de dados em memória)
- **JPA** (Java Persistence API)
- **Spring Data JPA**
- **Flyway** (Migrações de banco de dados)
- **Insomnia/Postman** (Para testes de API)

## Endpoints da API

### Reservas

- **POST** `/reservations` - Criar uma nova reserva.
- **GET** `/reservations` - Listar todas as reservas.
- **PUT** `/reservations/{id}` - Atualizar uma reserva existente.
- **DELETE** `/reservations/{id}` - Excluir uma reserva.
- **POST** `/reservations/check` - Verificar disponibilidade de uma sala para um determinado horário.

### Salas

- **POST** `/rooms` - Criar uma nova sala.
- **GET** `/rooms` - Listar todas as salas.
- **PUT** `/rooms/{id}` - Atualizar uma sala existente.
- **DELETE** `/rooms/{id}` - Excluir uma sala.

### Usuários

- **POST** `/users` - Criar um novo usuário.
- **GET** `/users` - Listar todos os usuários.
- **PUT** `/users/{id}` - Atualizar um usuário existente.
- **DELETE** `/users/{id}` - Excluir um usuário.

## Exemplos de Teste com JSON

### Criar uma nova reserva
**POST** `/reservations`
```json
{
  "roomId": 1,
  "userId": 1,
  "dataReserve": "2024-10-20",
  "timeStart": "10:00",
  "timeEnd": "12:00",
  "status": "Confirmado"
}
```

### Verificar a disponibilidade de uma sala
**POST** `/reservations/check`
```json
{
  "roomId": 1,
  "dataReserve": "2024-10-20",
  "timeStart": "10:00",
  "timeEnd": "12:00"
}
```

### Atualizar uma reserva existente
**PUT** `/reservations/{id}`
```json
{
  "roomId": 1,
  "userId": 2,
  "dataReserve": "2024-10-21",
  "timeStart": "14:00",
  "timeEnd": "16:00",
  "status": "Confirmado"
}
```

## Como Rodar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/O-Alexsandro/reserva-de-salas.git
   ```

2. Entre no diretório do projeto:
   ```bash
   cd reserva-de-salas
   ```

3. Rode o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em: `http://localhost:8080`

## Considerações Finais

Este projeto foi desenvolvido com o objetivo de facilitar a gestão de reservas de salas em uma empresa ou instituição. Qualquer contribuição ou sugestão é bem-vinda! 🚀
