package br.uefs.ecomp.bazar.view;

import java.awt.*;
import javax.swing.*;

public class TelaCadastroUsuario extends JPanel {

    public TelaCadastroUsuario(JPanel mainPanel) {
        initializeUI(mainPanel);
    }

    private void initializeUI(JPanel mainPanel) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Título da tela
        JLabel titleLabel = new JLabel("Cadastro de Usuário");
        titleLabel.setFont(new Font("Montserrat Bold", Font.BOLD, 30));
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;
        this.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        this.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        this.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        this.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        this.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        this.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Montserrat Bold", Font.PLAIN, 14));
        this.add(registerButton, gbc);

        gbc.gridx = 1;
        JButton backButton = new JButton("Voltar");
        backButton.setFont(new Font("Montserrat Bold", Font.PLAIN, 14));
        this.add(backButton, gbc);

        // Action listener para os botões
        backButton.addActionListener(e -> ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaLoginCadastro"));

        // Adicione lógica de registro conforme necessário
        registerButton.addActionListener(e -> {
            // Lógica de registro (exemplo simples)
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (registerUser(name, email, password)) {
                JOptionPane.showMessageDialog(mainPanel, "Usuário registrado com sucesso!");
                ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaLoginCadastro");
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Erro ao registrar usuário. Tente novamente.");
            }
        });
    }

    // Método de registro simples (substitua com a lógica real de registro)
    private boolean registerUser(String name, String email, String password) {
        // Para fins de demonstração, aceite qualquer registro não vazio
        return name != null && !name.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }
}
