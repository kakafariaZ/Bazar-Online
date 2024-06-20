package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Criar o painel principal com CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());
        mainPanel.add(new TelaLoginCadastro(mainPanel), "TelaLoginCadastro");
        mainPanel.add(new TelaOpcoesCompradorVendedor(mainPanel), "TelaOpcoesCompradorVendedor");
        mainPanel.add(new TelaOpcoesComprador(), "TelaOpcoesComprador");
        mainPanel.add(new TelaOpcoesVendedor(), "TelaOpcoesVendedor");
        mainPanel.add(new TelaCadastroUsuario(mainPanel), "TelaCadastroUsuario");

        // Configurar a janela principal
        JFrame frame = new JFrame("Sistema de Leilão Online");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(mainPanel);
        frame.setVisible(true);

        // Mostrar a tela de login/cadastro inicialmente
        ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaLoginCadastro");
    }
}
