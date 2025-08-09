package repository;

import model.Produto;
import java.sql.SQLException;
import java.util.List;

public interface ProdutoRepository {
    void adicionar(Produto p) throws SQLException;
    List<Produto> listar() throws SQLException;
    void atualizar(Produto p) throws SQLException;
    void remover(int id) throws SQLException;
    Produto buscarPorId(int id) throws SQLException;
}
