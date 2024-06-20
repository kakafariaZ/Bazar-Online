package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class MyAppSwing {

    public static void main(String[] args) {

        // Iniciar a aplicação Swing na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("LEILÃOONLINE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600); // Tamanho da janela
            frame.setLocationRelativeTo(null); // Centraliza a janela na tela

            // Painel principal com CardLayout
            JPanel mainPanel = new JPanel(new CardLayout());

            // Instâncias das telas
            TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro(mainPanel);
            TelaLoginUsuario telaLoginUsuario = new TelaLoginUsuario(mainPanel);
            TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario(mainPanel);

            // Adicionar as telas ao painel principal
            mainPanel.add(telaLoginCadastro, "TelaLoginCadastro");
            mainPanel.add(telaLoginUsuario, "TelaLoginUsuario");
            mainPanel.add(telaCadastroUsuario, "TelaCadastroUsuario");

            // Definir a tela inicial
            ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaLoginCadastro");

            frame.setContentPane(mainPanel);
            frame.setVisible(true);
        });
    }
}
