package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    public HomePage() {
        innit();
    }

    private void innit() {
        this.setTitle("Garden Ice");
        this.setBounds(400, 200, 400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel homeContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);// Top, left, bottom, right padding
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel header = new JLabel("Welcome Employee");
        header.setFont(new Font("SansSerif", Font.BOLD, 20));
        homeContainer.add(header, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        homeContainer.add(createButtonSubmit("Register"), gbc);

        gbc.gridx++;
        homeContainer.add(createButtonSubmit("View Member"), gbc);

        this.add(homeContainer);
        this.setVisible(true);
    }

    private JButton createButtonSubmit(String action){
        JButton button = new JButton(action);
        button.setBounds(10, 100, 200, 40);
        button.setEnabled(true);
        button.setVisible(true);
        button.addActionListener(this);

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Register":
                new RegisterPage();
                this.dispose();
                break;
            case "View Member":
                this.dispose();
                new SearchPage();
                break;
        }
        System.out.println(command);
    }
}
