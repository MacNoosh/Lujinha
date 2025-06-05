package Lujinha.view;

import javax.swing.*;
import Lujinha.model.Cliente;
import Lujinha.util.BancoDados;

public class TelaCadastroCliente extends JFrame {
    private JTextField campoNome = new JTextField();
    private JTextField campoCpf = new JTextField();
    private JRadioButton rbMasculino = new JRadioButton("Masculino");
    private JRadioButton rbFeminino = new JRadioButton("Feminino");
    private ButtonGroup grupoSexo = new ButtonGroup();

    private JCheckBox cbVarejo = new JCheckBox("Cliente varejo");
    private JCheckBox cbAtacado = new JCheckBox("Cliente atacado");
    private JCheckBox cbBloqueiaBoleto = new JCheckBox("Bloqueia Boleto");
    private JCheckBox cbInadimplente = new JCheckBox("Inadimplente");
    private JCheckBox cbInativo = new JCheckBox("Inativo");

    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnLimpar = new JButton("Limpar");

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(600, 450); 
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblSexo = new JLabel("Sexo:");

        lblNome.setBounds(30, 30, 100, 25);
        campoNome.setBounds(130, 30, 250, 25);
        lblCpf.setBounds(30, 70, 100, 25);
        campoCpf.setBounds(130, 70, 250, 25);
        lblSexo.setBounds(30, 110, 100, 25);
        rbMasculino.setBounds(130, 110, 100, 25);
        rbFeminino.setBounds(240, 110, 100, 25);

        JPanel painelChecks = new JPanel();
        painelChecks.setLayout(new BoxLayout(painelChecks, BoxLayout.Y_AXIS));
        painelChecks.setBounds(30, 160, 350, 140);
        painelChecks.setBorder(BorderFactory.createTitledBorder("Informações do cliente"));

        painelChecks.add(cbVarejo);
        painelChecks.add(cbAtacado);
        painelChecks.add(cbBloqueiaBoleto);
        painelChecks.add(cbInadimplente);
        painelChecks.add(cbInativo);

        btnSalvar.setBounds(130, 330, 100, 35);
        btnLimpar.setBounds(250, 330, 100, 35);

        grupoSexo.add(rbMasculino);
        grupoSexo.add(rbFeminino);

        add(lblNome);
        add(campoNome);
        add(lblCpf);
        add(campoCpf);
        add(lblSexo);
        add(rbMasculino);
        add(rbFeminino);
        add(painelChecks);
        add(btnSalvar);
        add(btnLimpar);

        btnSalvar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String sexo = rbMasculino.isSelected() ? "Masculino" :
                          rbFeminino.isSelected() ? "Feminino" : "Não informado";

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean varejo = cbVarejo.isSelected();
            boolean atacado = cbAtacado.isSelected();
            boolean bloqueiaBoleto = cbBloqueiaBoleto.isSelected();
            boolean inadimplente = cbInadimplente.isSelected();
            boolean inativo = cbInativo.isSelected();

            Cliente cliente = new Cliente(nome, sexo, cpf, varejo, atacado, bloqueiaBoleto, inadimplente, inativo);
            BancoDados.clientes.add(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            dispose();
        });

        btnLimpar.addActionListener(e -> {
            campoNome.setText("");
            campoCpf.setText("");
            grupoSexo.clearSelection();
            cbVarejo.setSelected(false);
            cbAtacado.setSelected(false);
            cbBloqueiaBoleto.setSelected(false);
            cbInadimplente.setSelected(false);
            cbInativo.setSelected(false);
        });
    }
}
