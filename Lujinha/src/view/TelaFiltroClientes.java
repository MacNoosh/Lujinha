package projetolojaswing.view;

import javax.swing.*;
import Lujinha.util.BancoDados;

public class TelaFiltroClientes extends JFrame {
    private JTextArea areaClientes = new JTextArea();

    public TelaFiltroClientes() {
        setTitle("Clientes Cadastrados");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        areaClientes.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(areaClientes);
        add(scrollPane); 

        for (var c : BancoDados.clientes) {
    areaClientes.append(
        "Nome: " + c.getNome() +
        ", CPF: " + c.getCpf() +
        ", Sexo: " + c.getSexo() +
        "\n→ Varejo: " + (c.isVarejo() ? "Sim" : "Não") +
        ", Atacado: " + (c.isAtacado() ? "Sim" : "Não") +
        ", Bloqueia Boleto: " + (c.isBloqueiaBoleto() ? "Sim" : "Não") +
        ", Inadimplente: " + (c.isInadimplente() ? "Sim" : "Não") +
        ", Inativo: " + (c.isInativo() ? "Sim" : "Não") +
        "\n\n"
    );
        }
    }
}
