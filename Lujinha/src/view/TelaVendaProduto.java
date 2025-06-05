package projetolojaswing.view;

import javax.swing.*;
import Lujinha.model.Cliente;
import Lujinha.model.Produto;
import Lujinha.util.BancoDados;

public class TelaVendaProduto extends JFrame {
    private JComboBox<String> comboClientes = new JComboBox<>();
    private JComboBox<String> comboProdutos = new JComboBox<>();
    private JTextField campoQtd = new JTextField();
    private JButton btnVender;
    private JButton btnLimpar;

    public TelaVendaProduto() {
        setTitle("Venda de Produto");
        setSize(500, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCliente = new JLabel("Cliente:");
        JLabel lblProduto = new JLabel("Produto:");
        JLabel lblQtd = new JLabel("Quantidade:");

        lblCliente.setBounds(20, 20, 80, 25);
        comboClientes.setBounds(110, 20, 220, 25);
        lblProduto.setBounds(20, 60, 80, 25);
        comboProdutos.setBounds(110, 60, 220, 25);
        lblQtd.setBounds(20, 100, 80, 25);
        campoQtd.setBounds(110, 100, 220, 25);

        // Ícones
        ImageIcon iconVender = new ImageIcon(getClass().getResource("/icone/venda.png"));
        ImageIcon iconLimpar = new ImageIcon(getClass().getResource("/icone/limpar.png"));

        btnVender = new JButton("Vender", iconVender);
        btnVender.setBounds(90, 150, 100, 30);

        btnLimpar = new JButton("Limpar", iconLimpar);
        btnLimpar.setBounds(200, 150, 100, 30);

        for (Cliente c : BancoDados.clientes) {
            comboClientes.addItem(c.getNome());
        }
        for (Produto p : BancoDados.produtos) {
            comboProdutos.addItem(p.getNome());
        }

        add(lblCliente);
        add(comboClientes);
        add(lblProduto);
        add(comboProdutos);
        add(lblQtd);
        add(campoQtd);
        add(btnVender);
        add(btnLimpar);

        btnVender.addActionListener(e -> {
            try {
                int qtd = Integer.parseInt(campoQtd.getText());
                Produto prod = BancoDados.produtos.get(comboProdutos.getSelectedIndex());
                double total = prod.getPreco() * qtd;

                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso. Total: R$ " + total);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida. Digite um número.");
            }
        });

        btnLimpar.addActionListener(e -> {
            comboClientes.setSelectedIndex(0);
            comboProdutos.setSelectedIndex(0);
            campoQtd.setText("");
        });
    }
}
