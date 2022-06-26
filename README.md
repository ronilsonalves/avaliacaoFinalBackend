# Avaliação Final - Especialização Back-end - Spring Cloud

> Este repositório está sendo utilizado para entrega dos exercícios de mesa de trabalho [ver branches](#) que por ventura implementem alguma nova funcionalidade aos microsserviços. A branch main destina-se apenas para apresentar os requisitos do pr

## Contextualização
O projeto consiste em 3 microsserviços: Filme, Série e Catálogo. O catálogo é um microsserviço que lê informações de Filmes e Séries a fim de enviar um catálogo ao cliente. O catálogo recebe uma mensagem toda vez que um filme ou uma série são lançados e os persiste em um banco de dados MongoDB não-relacional. Quando recebe uma solicitação do cliente, ele pesquisa o banco de dados e responde.

![Arquitetura de Microsserviços](enunciado-avaliacao-final.png)