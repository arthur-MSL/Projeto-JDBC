package ui;

import model.Produto;
import service.ProdutoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class MainUI extends JFrame {
    private ProdutoService produtoService;
    private JTable tabelaProdutos;
    private DefaultTableModel model;

    public MainUI(ProdutoService service) {
        super("Sistema de Gerenciamento de Produtos");
        this.produtoService = service;

        setLayout(new BorderLayout());

        // Tabela
        String[] colunas = {"ID", "Nome", "Preço", "Qtd"};
        model = new DefaultTableModel(colunas, 0);
        tabelaProdutos = new JTable(model);
        add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER);

        // Botões
        JPanel botoesPanel = new JPanel();
        JButton cadastrar = new JButton("Cadastrar Produto");
        JButton vender = new JButton("Vender Produto");
        JButton comprar = new JButton("Comprar Produto");

        botoesPanel.add(cadastrar);
        botoesPanel.add(vender);
        botoesPanel.add(comprar);
        add(botoesPanel, BorderLayout.SOUTH);

        cadastrar.addActionListener(e -> new CadastrarProdutoUI(produtoService, this));
        vender.addActionListener(e -> new VenderProdutoUI(produtoService, this));
        comprar.addActionListener(e -> new ComprarProdutoUI(produtoService, this));

        atualizarTabela();

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void atualizarTabela() {
        model.setRowCount(0);
        try {
            List<Produto> produtos = produtoService.listarProdutos();
            for (Produto p : produtos) {
                model.addRow(new Object[]{p.getId(), p.getNome(), p.getPreco(), p.getQtd()});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
