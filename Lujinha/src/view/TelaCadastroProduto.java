package Lujinha.view;

import javax.swing.*;
import Lujinha.model.Produto;
import Lujinha.util.BancoDados;

public class TelaCadastroProduto extends JFrame {
    private JTextField campoNome = new JTextField();
    private JTextField campoQtd = new JTextField();
    private JTextField campoPreco = new JTextField();
    private JButton btnSalvar;
    private JButton btnLimpar;

    public TelaCadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblQtd = new JLabel("Quantidade:");
        JLabel lblPreco = new JLabel("Preço:");

        lblNome.setBounds(20, 20, 100, 25);
        campoNome.setBounds(120, 20, 180, 25);
        lblQtd.setBounds(20, 60, 100, 25);
        campoQtd.setBounds(120, 60, 180, 25);
        lblPreco.setBounds(20, 100, 100, 25);
        campoPreco.setBounds(120, 100, 180, 25);

        ImageIcon iconSalvar = new ImageIcon(getClass().getResource("/icone/salvar.png"));
        ImageIcon iconLimpar = new ImageIcon(getClass().getResource("/icone/limpar.png"));

        btnSalvar = new JButton("Salvar", iconSalvar);
        btnSalvar.setBounds(70, 150, 100, 30);

        btnLimpar = new JButton("Limpar", iconLimpar);
        btnLimpar.setBounds(180, 150, 100, 30);

        add(lblNome);
        add(campoNome);
        add(lblQtd);
        add(campoQtd);
        add(lblPreco);
        add(campoPreco);
        add(btnSalvar);
        add(btnLimpar);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                int qtd = Integer.parseInt(campoQtd.getText());
                double preco = Double.parseDouble(campoPreco.getText().replace(",", "."));

                Produto p = new Produto(nome, qtd, preco);
                BancoDados.produtos.add(p);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantidade ou preço inválido. Use números válidos.\nEx: 10.5 ou 10,5 para o preço.");
            }
        });

        btnLimpar.addActionListener(e -> {
            campoNome.setText("");
            campoQtd.setText("");
            campoPreco.setText("");
        });
    }
}
