# Aplicação Bancária com RabbitMQ

Esta aplicação bancária foi desenvolvida para gerenciar o cadastro de cartões de clientes e consultas de limite de crédito utilizando uma arquitetura assíncrona com RabbitMQ. O design modular e a integração por meio de mensageria proporcionam uma experiência eficiente e escalável.

## Funcionalidades

- **Cadastro de Cartão do Cliente**:  
  Permite que os clientes cadastrem suas informações de cartão. Os dados são enviados para uma fila RabbitMQ, onde são processados por um serviço dedicado que realiza a persistência no banco de dados.

- **Consulta de Limite de Crédito**:  
  Os clientes podem consultar seu limite de crédito de forma rápida e simples. As requisições são enviadas para uma fila específica, onde um consumidor processa a consulta e retorna a informação ao cliente.

## Vantagens da Arquitetura Assíncrona

- **Desacoplamento**: Os serviços são independentes, permitindo uma manutenção e escalabilidade mais fáceis.
- **Escalabilidade**: Novos consumidores podem ser adicionados para lidar com um aumento na demanda.
- **Resiliência**: Falhas em um serviço não impactam diretamente os outros, garantindo maior disponibilidade.

## Tecnologias Utilizadas

- **RabbitMQ**: Para a mensageria assíncrona.
- **Java/Spring Boot**: Para o desenvolvimento dos serviços.
- **Banco de Dados**: Para a persistência de dados.

## Como Executar

1. **Configurar o RabbitMQ**: Certifique-se de que o RabbitMQ está instalado e em execução.
2. **Configurar o Banco de Dados**: Ajuste as configurações de conexão no arquivo de propriedades da aplicação.
3. **Executar a Aplicação**: Inicie a aplicação e utilize os endpoints disponíveis para cadastro e consulta de cartões.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias.
