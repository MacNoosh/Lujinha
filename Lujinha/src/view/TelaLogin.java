package Lujinha.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Lujinha.util.BancoDados;

public class TelaLogin extends JFrame {
    private JTextField campoUsuario = new JTextField();
    private JPasswordField campoSenha = new JPasswordField();
    private JButton btnEntrar;

    public TelaLogin() {
        setTitle("Tela de Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        JLabel lblSenha = new JLabel("Senha:");

        lblUsuario.setBounds(30, 30, 100, 25);
        campoUsuario.setBounds(110, 30, 180, 25);
        lblSenha.setBounds(30, 70, 100, 25);
        campoSenha.setBounds(110, 70, 180, 25);

        ImageIcon iconLogin = new ImageIcon(getClass().getResource("/icone/Login.png"));

        btnEntrar = new JButton("Entrar", iconLogin);
        btnEntrar.setBounds(110, 110, 120, 30);

        btnEntrar.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            if (usuario.equals("admin") && senha.equals("123")) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                new TelaMenuPrincipal().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(lblUsuario);
        add(campoUsuario);
        add(lblSenha);
        add(campoSenha);
        add(btnEntrar);
    }
}
