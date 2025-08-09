package app;

import repository.ProdutoDAOImpl;
import service.ProdutoService;
import ui.MainUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        ProdutoDAOImpl repo = new ProdutoDAOImpl();
        ProdutoService service = new ProdutoService(repo);

        SwingUtilities.invokeLater(() -> {
            MainUI ui = new MainUI(service);
            ui.setVisible(true);
        });
    }
}
