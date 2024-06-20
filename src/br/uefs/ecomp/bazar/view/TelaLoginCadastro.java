package br.uefs.ecomp.bazar.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaLoginCadastro extends JPanel {

    public TelaLoginCadastro(JPanel mainPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        // Usar HTML para definir cores diferentes em um JLabel
        JLabel labelTitulo = new JLabel("<html><span style='color:black'>LEILÃO</span><span style='color:blue'>ONLINE</span></html>");
        labelTitulo.setFont(new Font("Montserrat Bold", Font.BOLD, 50));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(labelTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
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
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Montserrat Bold", Font.PLAIN, 14));
        add(loginButton, gbc);

        gbc.gridx = 1;
        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.setFont(new Font("Montserrat Bold", Font.PLAIN, 14));
        add(cadastroButton, gbc);

        // Action listener para os botões
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simular verificação de credenciais e pular a tela de login
                String username = loginField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticate(username, password)) {
                    // Mostrar a próxima tela após a autenticação bem-sucedida
                    ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaOpcoesCompradorVendedor");
                } else {
                    // Mostrar mensagem de erro se as credenciais forem inválidas
                    JOptionPane.showMessageDialog(mainPanel, "Credenciais inválidas, tente novamente.");
                }
            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) mainPanel.getLayout()).show(mainPanel, "TelaCadastroUsuario");
            }
        });
    }

    // Método de autenticação simples (substitua com a lógica real de autenticação)
    private boolean authenticate(String username, String password) {
        // Para fins de demonstração, aceite qualquer combinação de usuário/senha não vazia
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}
