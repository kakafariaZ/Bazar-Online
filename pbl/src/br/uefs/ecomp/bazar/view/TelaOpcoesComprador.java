package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class TelaOpcoesComprador extends JPanel {

    public TelaOpcoesComprador() {
        initializeUI();
    }

    private void initializeUI() {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Opções do Comprador", SwingConstants.CENTER);
        label.setFont(new Font("Montserrat Bold", Font.PLAIN, 24));
        this.add(label, BorderLayout.CENTER);

        this.setBackground(Color.WHITE);
    }
}
