package service;

import model.Produto;
import repository.ProdutoRepository;

import java.sql.SQLException;
import java.util.List;

public class ProdutoService {
    private ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public void adicionarProduto(Produto p) throws SQLException {
        repo.adicionar(p);
    }

    public List<Produto> listarProdutos() throws SQLException {
        return repo.listar();
    }

    public void atualizarProduto(Produto p) throws SQLException {
        repo.atualizar(p);
    }

    public void removerProduto(int id) throws SQLException {
        repo.remover(id);
    }

    public Produto buscarProduto(int id) throws SQLException {
        return repo.buscarPorId(id);
    }

    public void comprar(int id, int quantidade) throws SQLException {
        Produto p = repo.buscarPorId(id);
        if (p != null) {
            p.setQtd(p.getQtd() + quantidade);
            repo.atualizar(p);
        }
    }

    public void vender(int id, int quantidade) throws SQLException {
        Produto p = repo.buscarPorId(id);
        if (p != null && p.getQtd() >= quantidade) {
            p.setQtd(p.getQtd() - quantidade);
            repo.atualizar(p);
        }
    }
}
