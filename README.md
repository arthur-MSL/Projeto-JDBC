# 🛒 Sistema de Gerenciamento de Produtos

Um sistema desenvolvido em **Java** com **Swing** para gerenciamento de produtos, incluindo funcionalidades de listagem, venda, cadastro e atualização em tempo real.

---

## 📌 Funcionalidades

- **Listagem de Produtos**  
  Exibe todos os produtos cadastrados com atualização automática em tempo real.
  
- **Venda de Produtos**  
  Permite selecionar um produto e registrar uma venda, atualizando o estoque imediatamente.

- **Cadastro de Produtos**  
  Adiciona novos produtos com nome, preço e quantidade inicial.

- **Atualização de Estoque**  
  Modifica a quantidade e preço de produtos já cadastrados.

---

## 🗂 Estrutura do Projeto

src/
├── app/
│ ├── Main.java
│
├── model/
│ ├── Produto.java
│
├── repository/
│ ├── ProdutoRepository.java
│
├── service/
│ ├── ProdutoService.java
│
├── ui/
│ ├── CadastroProdutoUI.java
│ ├── VenderProdutoUI.java
│ ├── ListagemProdutosUI.java
│
└── util/
├── ConnectionFactory.java


---

## 🚀 Como Executar

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
2. **Compile o projeto**
   ```bash
   javac -d bin src/**/*.java
3. **Execute o programa**
  ```bash
  java -cp bin app.Main

