package model;

public class Produto {
    private int id;
    private String nome;
    private int qtd;
    private double preco;

    public Produto(int id, String nome, int qtd, double preco) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getQtd() { return qtd; }
    public void setQtd(int qtd) { this.qtd = qtd; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return id + " - " + nome + " (Qtd: " + qtd + ", Preço: " + preco + ")";
    }
}
