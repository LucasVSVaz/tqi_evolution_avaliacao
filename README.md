# Desafio final - Bootcamp DIO - TQI

Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:   

i. Cadastro de clientes
O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.

iii. Solicitação de empréstimo
Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.

iv. Acompanhamento das solicitações de empréstimo
O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

## Tecnologias Utilizadas
O projeto foi criado com Spring Boot na linguagem de programação Java com BD MariaDB, Spring Data JPA, Validation, Web e Lombok.

## Arquitetura
O projeto está divido nas seguintes camadas:

*main:*
1. Entity;
2. Repository;
3. Service;
4. Controller;
5. DTO - Response/request;
6. Exceptions.

## Como testar
1. **``POST /api/v1/client``**: Cadastro do cliente.
```javascript
{
    "name":"José da silva",
        "cpf":"04304430050",
        "rg":"mg1816478",
        "email":"jose@gmail.com",
        "password":"jose10",
        "income": 5000,
        "address":[
        {
            "state": "MG",
            "city":"Uberlândia",
            "district":"Jardim Brasília",
            "street":"Rua Teste",
            "number":1080,
            "cep": "31535496"
        }
    ]
}
```   


2. **``POST /api/v1/loan``**: Solicitação de empréstimo.
```javascript
{
    "value": 5000,
    "firstInstallmentDate": "25/01/2022",
    "numberInstallments":5,
    "client":{
        "id":3
    }
}
```

3. **``GET /api/v1/client/loan/list``**: Lista todos os empréstimos cadastrados.

4. **``GET /api/v1/client/loan/list/{id}``**: Lista todos os empréstimos vinculados ao ID do Cliente.

5. **``GET /api/v1/loan/detail``**: Retorna os detalhes do empréstimo.


