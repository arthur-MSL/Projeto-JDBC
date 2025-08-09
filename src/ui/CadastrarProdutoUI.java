package ui;

import model.Produto;
import service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class CadastrarProdutoUI extends JFrame {
    public CadastrarProdutoUI(ProdutoService service, MainUI mainUI) {
        super("Cadastrar Produto");

        setLayout(new GridLayout(4, 2));

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();
        JLabel labelPreco = new JLabel("Preço:");
        JTextField campoPreco = new JTextField();
        JLabel labelQtd = new JLabel("Quantidade:");
        JTextField campoQtd = new JTextField();
        JButton cadastrarButton = new JButton("Cadastrar");

        add(labelNome); add(campoNome);
        add(labelPreco); add(campoPreco);
        add(labelQtd); add(campoQtd);
        add(new JLabel()); add(cadastrarButton);

        cadastrarButton.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                int qtd = Integer.parseInt(campoQtd.getText());
                Produto produto = new Produto(0, nome, qtd, preco); // ID será gerado pelo banco
                service.adicionarProduto(produto);
                JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                mainUI.atualizarTabela(); // Atualiza tabela
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
