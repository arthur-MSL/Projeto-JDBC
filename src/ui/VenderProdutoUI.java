package ui;

import service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class VenderProdutoUI extends JFrame {
    public VenderProdutoUI(ProdutoService service, MainUI mainUI) {
        super("Vender Produto");

        setLayout(new GridLayout(3, 2));

        JLabel labelId = new JLabel("ID do Produto:");
        JTextField campoId = new JTextField();
        JLabel labelQtd = new JLabel("Quantidade:");
        JTextField campoQtd = new JTextField();
        JButton venderButton = new JButton("Vender");

        add(labelId); add(campoId);
        add(labelQtd); add(campoQtd);
        add(new JLabel()); add(venderButton);

        venderButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());
                int qtd = Integer.parseInt(campoQtd.getText());
                service.vender(id, qtd);
                JOptionPane.showMessageDialog(null, "Venda realizada!");
                mainUI.atualizarTabela(); // Atualiza tabela no MainUI
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
