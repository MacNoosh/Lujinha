package projetolojaswing.view;

import javax.swing.*;
import Lujinha.util.BancoDados;

public class TelaFiltroProdutos extends JFrame {
    private JTextArea areaProdutos = new JTextArea();

    public TelaFiltroProdutos() {
        setTitle("Produtos Cadastrados");
        setSize(600, 400);
        setLocationRelativeTo(null);

        areaProdutos.setEditable(false);

        for (var p : BancoDados.produtos) {
            areaProdutos.append("Produto: " + p.getNome() + ", Preço: R$" + String.format("%.2f", p.getPreco()) + "\n");
        }

        JScrollPane scroll = new JScrollPane(areaProdutos);
        add(scroll);
    }
}
