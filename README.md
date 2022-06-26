# Integradora VI - Especialização Back-end - Spring Cloud


## Exercício da Mesa de Trabalho
Nossa locadora de filmes agora necessita de alta disponibilidade em seus serviços para cadastrar novos filmes automaticamente. Para tanto, vamos implementar um servidor de configurações para simplificar a modificação dos nossos microsserviços se necessário, o Eureka para facilitar a visibilidade entre os microsserviços, o Zipkin para observar o tempo de requisição e resposta das chamadas do nosso sistema e das comunicações entre os microsserviços e, por último, o RabbitMQ, onde será implementado uma fila de requisições assíncronas.

## Instruções

* [1] Configure seu servidor de configurações e suba o serviço;
</br>

* [2] Configure seu servidor Eureka, garantindo sua conexão com o servidor de configurações para recuperar os parâmetros do Eureka;
</br>

* [3] Configure seus servidores RabbitMQ e Zipkin através do docker-compose e suba os serviços;
</br>

* [4] Crie o microsserviço “movie-service” com uma REST API contendo os endpoints necessários para recuperar e salvar um novo filme;
</br>

* [5] Crie o microsserviço "catalog-service" com uma REST API para catalogar os novos filmes através da fila do RabbitMQ;


    - [5.1] O serviço “catalog-service” deve enviar os filmes para a fila do serviço “movie-service” através do OpenFeign;


- [6] Crie um circuit breaker entre os dois microsserviços anteriores, garantindo que as requisições de um microsserviço para o outro seja roteado pelo circuit breaker.
