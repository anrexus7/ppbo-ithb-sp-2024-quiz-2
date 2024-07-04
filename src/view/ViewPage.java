package view;

import controller.GetDataMember;
import model.Class.Member;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ViewPage extends JFrame {
    Member temp;
    public ViewPage(int i){
        temp = GetDataMember.getData(i);
        innit();
    }

    public void innit() {
        this.setTitle("Hasil Kartu");
        this.setBounds(400, 200, 800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 0);// Top, left, bottom, right padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        container.add(createButtonSubmit("back"), gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(createLeftLayout(),gbc);

        gbc.gridx++;
        container.add(createRightLayout(),gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        container.add(new JLabel("If you happend to find this card, please return it to this address : "),gbc);

        ImageIcon imageIcon = new ImageIcon("C:\\Kuliah\\semester pendek (2 ke 3)\\OOP\\quiz2\\quiz2_assets\\Picture6\\Picture6-0000.jpg");
        JLabel labelFoto = new JLabel(imageIcon);
        labelFoto.setVisible(true);

        gbc.gridy++;
        gbc.gridwidth = 1;
        container.add(labelFoto,gbc);

        ImageIcon imageIconBarcode = new ImageIcon("C:\\Kuliah\\semester pendek (2 ke 3)\\OOP\\quiz2\\quiz2_assets\\Picture1\\Picture1-0000.jpg");
        JLabel labelFotoBC = new JLabel(imageIconBarcode);
        labelFoto.setVisible(true);

        gbc.gridx++;
        container.add(labelFotoBC,gbc);

        this.add(container);
        this.setVisible(true);
    }

    private JPanel createRightLayout(){
        JPanel leftContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        gbcL.insets = new Insets(0, 10, 10, 0);// Top, left, bottom, right padding
        gbcL.anchor = GridBagConstraints.WEST;

        gbcL.gridx = 0;
        gbcL.gridy = 0;
        leftContainer.add(new JLabel("Name "), gbcL);

        gbcL.gridx++;
        leftContainer.add(new JLabel(temp.getNama()),gbcL);

        gbcL.gridy++;
        gbcL.gridx--;
        leftContainer.add(new JLabel("Birth Date "), gbcL);

        gbcL.gridx++;
        leftContainer.add(new JLabel(String.valueOf(temp.getTanggalLahir())),gbcL);

        gbcL.gridy++;
        gbcL.gridx--;
        leftContainer.add(new JLabel("Valid Until "), gbcL);

        gbcL.gridx++;
        leftContainer.add(new JLabel(String.valueOf(temp.getTanggalExp())),gbcL);

        gbcL.gridy++;
        gbcL.gridx--;
        leftContainer.add(new JLabel("NO. "), gbcL);

        gbcL.gridx++;
        leftContainer.add(new JLabel("G-000-001-001"),gbcL);

        return leftContainer;
    }

    private JPanel createLeftLayout(){
        JPanel rightContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.insets = new Insets(10, 10, 10, 10);// Top, left, bottom, right padding
        gbcR.anchor = GridBagConstraints.WEST;

        ImageIcon imageIcon = new ImageIcon(temp.getFotoMember());
        Image originalImage = imageIcon.getImage();
        Image scaledImage;
        scaledImage = originalImage.getScaledInstance(200, 280, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel labelFoto = new JLabel(scaledIcon);
        labelFoto.setVisible(true);

        gbcR.gridx = 0;
        gbcR.gridy = 0;
        rightContainer.add(labelFoto,gbcR);

        return rightContainer;
    }

    private JButton createButtonSubmit(String action){
        JButton button = new JButton(action);
        button.setBounds(10, 100, 200, 40);
        button.setEnabled(true);
        button.setVisible(true);

        button.addActionListener(e ->{
            new HomePage();
            this.dispose();
        });

        return button;
    }
}
