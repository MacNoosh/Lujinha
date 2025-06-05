package Lujinha.view;

import javax.swing.*;
import java.awt.*;
import projetolojaswing.view.TelaFiltroClientes;
import projetolojaswing.view.TelaFiltroProdutos;
import projetolojaswing.view.TelaVendaProduto;

public class TelaMenuPrincipal extends JFrame {
    private JMenuBar menuBar = new JMenuBar();

    public TelaMenuPrincipal() {
        setTitle("Menu Principal");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(50, 50, 50));
        setLayout(null); 

        JMenu menuCadastros = new JMenu("Cadastros");
        JMenu menuFiltros = new JMenu("Filtros");
        JMenu menuVendas = new JMenu("Vendas");

        JMenuItem itemCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem itemProduto = new JMenuItem("Cadastrar Produto");
        JMenuItem itemFiltrarClientes = new JMenuItem("Listar Clientes");
        JMenuItem itemFiltrarProdutos = new JMenuItem("Listar Produtos");
        JMenuItem itemVenda = new JMenuItem("Vender Produto");

        itemCliente.addActionListener(e -> new TelaCadastroCliente().setVisible(true));
        itemProduto.addActionListener(e -> new TelaCadastroProduto().setVisible(true));
        itemFiltrarClientes.addActionListener(e -> new TelaFiltroClientes().setVisible(true));
        itemFiltrarProdutos.addActionListener(e -> new TelaFiltroProdutos().setVisible(true));
        itemVenda.addActionListener(e -> new TelaVendaProduto().setVisible(true));

        menuCadastros.add(itemCliente);
        menuCadastros.add(itemProduto);
        menuFiltros.add(itemFiltrarClientes);
        menuFiltros.add(itemFiltrarProdutos);
        menuVendas.add(itemVenda);

        menuBar.add(menuCadastros);
        menuBar.add(menuFiltros);
        menuBar.add(menuVendas);

        setJMenuBar(menuBar);
    }
}
