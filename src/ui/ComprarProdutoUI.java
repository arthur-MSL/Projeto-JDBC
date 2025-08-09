package ui;

import service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class ComprarProdutoUI extends JFrame {
    public ComprarProdutoUI(ProdutoService service, MainUI mainUI) {
        super("Comprar Produto");

        setLayout(new GridLayout(3, 2));

        JLabel labelId = new JLabel("ID do Produto:");
        JTextField campoId = new JTextField();
        JLabel labelQtd = new JLabel("Quantidade:");
        JTextField campoQtd = new JTextField();
        JButton comprarButton = new JButton("Comprar");

        add(labelId); add(campoId);
        add(labelQtd); add(campoQtd);
        add(new JLabel()); add(comprarButton);

        comprarButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());
                int qtd = Integer.parseInt(campoQtd.getText());
                service.comprar(id, qtd);
                JOptionPane.showMessageDialog(null, "Compra realizada!");
                mainUI.atualizarTabela(); // Atualiza tabela
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
