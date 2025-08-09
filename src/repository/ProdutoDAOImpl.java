package repository;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoRepository {
    private static final String URL = "jdbc:derby:meuBancoDerby;create=true";

    public ProdutoDAOImpl() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE PRODUTO (id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, nome VARCHAR(100), qtd INT, preco DOUBLE)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // Se tabela já existir, ignora o erro
            if (!e.getSQLState().equals("X0Y32")) {
                e.printStackTrace();
            }
        }
    }

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    @Override
    public void adicionar(Produto p) throws SQLException {
        String sql = "INSERT INTO PRODUTO (nome, qtd, preco) VALUES (?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getQtd());
            ps.setDouble(3, p.getPreco());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Produto> listar() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("qtd"),
                    rs.getDouble("preco")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    @Override
    public void atualizar(Produto p) throws SQLException {
        String sql = "UPDATE PRODUTO SET nome = ?, qtd = ?, preco = ? WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getQtd());
            ps.setDouble(3, p.getPreco());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("qtd"),
                        rs.getDouble("preco")
                    );
                }
            }
        }
        return null;
    }
}
