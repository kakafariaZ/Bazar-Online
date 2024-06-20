package br.uefs.ecomp.bazar.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginUsuario extends JPanel {

    public TelaLoginUsuario(JPanel mainPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        JLabel labelTitulo = new JLabel("Login de Usuário");
        labelTitulo.setFont(new Font("Montserrat Bold", Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Login:"), gbc);

        gbc.gridx = 1;
        JTextField loginField = new JTextField(20);
        add(loginField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(new Font("Montserrat Bold", Font.PLAIN, 14));
        add(loginButton, gbc);

        // Action listener para o botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Login efetuado com sucesso!");
                // Aqui você pode mudar para a próxima tela
            }
        });
    }
}
