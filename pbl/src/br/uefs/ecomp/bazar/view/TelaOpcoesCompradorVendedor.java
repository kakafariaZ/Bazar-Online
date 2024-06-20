package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class TelaOpcoesCompradorVendedor extends JPanel {

    public TelaOpcoesCompradorVendedor(JPanel mainPanel) {
        initializeUI(mainPanel);
    }

    private void initializeUI(JPanel mainPanel) {
        this.setLayout(new GridLayout(2, 1, 10, 10)); // Grid para duas opções

        JButton btnComprador = new JButton("Opções do Comprador");
        btnComprador.setFont(new Font("Montserrat Bold", Font.PLAIN, 16));
        btnComprador.addActionListener(e -> {
            // Lógica para abrir opções do comprador
            ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaOpcoesComprador");
        });
        this.add(btnComprador);

        JButton btnVendedor = new JButton("Opções do Vendedor");
        btnVendedor.setFont(new Font("Montserrat Bold", Font.PLAIN, 16));
        btnVendedor.addActionListener(e -> {
            // Lógica para abrir opções do vendedor
            ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaOpcoesVendedor");
        });
        this.add(btnVendedor);

        this.setBackground(Color.WHITE);
    }
}
