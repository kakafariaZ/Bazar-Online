package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class TelaCadastroLeilao extends JPanel {
    private JTextField campoDescricaoResumida;
    private JTextArea campoDescricaoDetalhada;
    private JTextField campoPrecoMinimo;
    private JTextField campoTempoTermino;

    public TelaCadastroLeilao() {
        initializeUI();
    }

    private void initializeUI() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel labelDescricaoResumida = new JLabel("Descrição Resumida:");
        this.add(labelDescricaoResumida, gbc);

        gbc.gridx++;
        campoDescricaoResumida = new JTextField(30);
        this.add(campoDescricaoResumida, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelDescricaoDetalhada = new JLabel("Descrição Detalhada:");
        this.add(labelDescricaoDetalhada, gbc);

        gbc.gridx++;
        campoDescricaoDetalhada = new JTextArea(5, 30);
        campoDescricaoDetalhada.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(campoDescricaoDetalhada);
        this.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelPrecoMinimo = new JLabel("Preço Mínimo:");
        this.add(labelPrecoMinimo, gbc);

        gbc.gridx++;
        campoPrecoMinimo = new JTextField(10);
        this.add(campoPrecoMinimo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel labelTempoTermino = new JLabel("Tempo de Término:");
        this.add(labelTempoTermino, gbc);

        gbc.gridx++;
        campoTempoTermino = new JTextField(20);
        this.add(campoTempoTermino, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Montserrat Bold", Font.PLAIN, 16));
        this.add(btnCadastrar, gbc);

        btnCadastrar.addActionListener(e -> {
            // Lógica para cadastrar o leilão
            JOptionPane.showMessageDialog(this, "Botão Cadastrar clicado");
        });

        this.setBackground(Color.WHITE);
    }
}
