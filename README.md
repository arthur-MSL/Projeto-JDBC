🛒 Sistema de Gerenciamento de Produtos
Este projeto é um Sistema de Gerenciamento de Produtos desenvolvido em Java, utilizando JDBC para integração com banco de dados Apache Derby e Swing para a interface gráfica.
O código segue princípios SOLID e uma estrutura organizada em pacotes para garantir escalabilidade e manutenção facilitada.

📌 Funcionalidades
Cadastrar Produto – Adiciona novos produtos ao sistema.

Listar Produtos – Exibe todos os produtos em uma tabela organizada.

Editar Produto – Permite atualizar as informações de um produto existente.

Excluir Produto – Remove produtos do banco de dados.

Vender Produto – Atualiza a quantidade disponível após uma venda.

📂 Estrutura do Projeto
src/
│── app/                  # Classe principal para iniciar o sistema
│── model/                # Entidades e classes de domínio
│── repository/           # Acesso e manipulação do banco de dados (DAO)
│── service/               # Lógica de negócios
│── ui/                    # Interfaces gráficas (Swing)
│── util/                  # Utilitários e helpers

🛠 Tecnologias Utilizadas
Java 17+

Swing (Interface Gráfica)

JDBC (Conexão com o banco)

Apache Derby (Banco de Dados)

Padrões de Projeto: DAO, MVC e princípios SOLID

🚀 Como Executar
Clonar o repositório


git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

Configurar o banco de dados Apache Derby

O Derby é configurado automaticamente via JDBC embutido no projeto.

Certifique-se de que a pasta de dados esteja acessível.

Compilar e executar o projeto


javac -cp "lib/*;src" -d bin src/app/Main.java
java -cp "lib/*;bin" app.Main


👨‍💻 Autor
Arthur Marques Soares Lima

Ciência da Computação - UFU

Técnico em Redes de Computadores - IFTM


