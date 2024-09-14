
# Workshop Spring Boot com MongoDB

Este projeto é uma aplicação construída com Spring Boot e MongoDB, servindo como um exemplo prático de como integrar esses dois frameworks para construir uma API RESTful. O projeto inclui a modelagem de usuários, posts e comentários, permitindo a interação entre essas entidades.

## Estrutura do Projeto

O diagrama de classes do projeto consiste em três principais entidades:

- **User**: Representa os usuários do sistema.
  - Atributos: `id`, `name`, `email`
  - Relação: Um usuário pode ter múltiplos posts.

- **Post**: Representa as postagens criadas pelos usuários.
  - Atributos: `id`, `date`, `title`, `body`
  - Relação: Um post é criado por um único usuário e pode ter múltiplos comentários.

- **Comment**: Representa os comentários feitos nos posts.
  - Atributos: `id`, `text`, `date`
  - Relação: Um comentário pertence a um único post.

## Tecnologias Utilizadas

- Java
- Spring Boot
- MongoDB
- Maven

## Pré-requisitos

Certifique-se de ter os seguintes itens instalados e configurados em seu ambiente:

- JDK 11 ou superior
- Maven
- MongoDB

## Configuração do Projeto

1. Clone o repositório do projeto:

   ```bash
   git clone https://github.com/Paulo-dosSantos/workshop_springboot_mongodb.git
