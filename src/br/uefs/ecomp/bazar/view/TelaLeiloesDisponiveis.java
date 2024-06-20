package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class TelaLeiloesDisponiveis extends JPanel {

    public TelaLeiloesDisponiveis() {
        initializeUI();
    }

    private void initializeUI() {
        this.setLayout(new BorderLayout());

        DefaultListModel<String> leiloesModel = new DefaultListModel<>();
        JList<String> listLeiloes = new JList<>(leiloesModel);
        JScrollPane scrollPane = new JScrollPane(listLeiloes);
        this.add(scrollPane, BorderLayout.CENTER);

        JButton btnParticipar = new JButton("Participar");
        btnParticipar.setFont(new Font("Montserrat Bold", Font.PLAIN, 16));
        btnParticipar.addActionListener(e -> {
            // Lógica para participar do leilão selecionado
            JOptionPane.showMessageDialog(this, "Botão Participar clicado");
        });
        this.add(btnParticipar, BorderLayout.SOUTH);

        this.setBackground(Color.WHITE);
    }
}
