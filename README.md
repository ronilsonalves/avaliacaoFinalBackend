# Avaliação Final - Especialização Back-end - Spring Cloud
Esta avaliação será diferente da anterior, pois a construiremos durante as aulas seguintes. Isto não significa que a resolveremos durante as reuniões ao vivo, mas com os tópicos que cobriremos você poderá completar as exigências.
> Além disso, este repositório está sendo utilizado para entrega dos exercícios de mesa de trabalho [ver branches](#) que por ventura implementem alguma nova funcionalidade aos microsserviços.

## Contextualização
O projeto consiste em 3 microsserviços: Filme, Série e Catálogo. O catálogo é um microsserviço que lê informações de Filmes e Séries a fim de enviar um catálogo ao cliente. O catálogo recebe uma mensagem toda vez que um filme ou uma série são lançados e os persiste em um banco de dados MongoDB não-relacional. Quando recebe uma solicitação do cliente, ele pesquisa o banco de dados e responde.

![Arquitetura de Microsserviços](enunciado-avaliacao-final.png)