package view;

import controller.GetDataMember;
import controller.RegisterController;
import model.Class.DateLabelFormatter;
import model.Enum.JenisKelamin;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class RegisterPage extends JFrame implements ActionListener {
    private JTextField fieldNama;
    private JDatePicker fieldLahir;
    private JDatePicker fieldBuat;
    private ButtonGroup fieldKelamin;
    private JFileChooser fieldFoto;

    public RegisterPage() {
        innit();
    }

    private void innit() {
        this.setTitle("Form Registrasi");
        this.setBounds(400, 200, 700, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel homeContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 30, 10, 0);// Top, left, bottom, right padding
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel header = new JLabel("Form Registrasi Member GardenIce");
        header.setFont(new Font("SansSerif", Font.BOLD, 20));
        homeContainer.add(header, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        homeContainer.add(createPanel("Nama Lengkap"), gbc);

        gbc.gridx++;
        fieldNama = new JTextField(18);
        homeContainer.add(fieldNama, gbc);

        gbc.gridy++;
        gbc.gridx--;
        homeContainer.add(createPanel("Jenis Kelamin"), gbc);

        gbc.gridx++;
        homeContainer.add(createInputRadioGenderPanel(), gbc);


        gbc.gridy++;
        gbc.gridx--;
        homeContainer.add(createPanel("Tanggal Lahir"), gbc);

        gbc.gridx++;
        fieldLahir = new JDatePickerImpl(createDatePanel(), new DateLabelFormatter());
        homeContainer.add((Component) fieldLahir, gbc);

        gbc.gridy++;
        gbc.gridx--;
        homeContainer.add(createPanel("Foto Member"), gbc);

        gbc.gridx++;
        fieldFoto = new JFileChooser();
        homeContainer.add(fieldFoto, gbc);

        gbc.gridy++;
        gbc.gridx--;
        homeContainer.add(createPanel("Tanggal Buat"), gbc);

        gbc.gridx++;
        fieldBuat = new JDatePickerImpl(createDatePanel(), new DateLabelFormatter());
        homeContainer.add((Component) fieldBuat, gbc);

        gbc.gridy++;
        gbc.gridx--;
        homeContainer.add(createButtonSubmit("Submit"), gbc);

        gbc.gridx++;
        homeContainer.add(createButtonSubmit("Exit"), gbc);

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

    private static JLabel createPanel(String labelText) {
        JLabel label = new JLabel(labelText);
        return label;
    }

    private JPanel createInputRadioGenderPanel() {
        JPanel panel = new JPanel();

        JRadioButton radioButtonM = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        JRadioButton radioButtonF = new JRadioButton(String.valueOf(JenisKelamin.WANITA));

        radioButtonM.setActionCommand(radioButtonM.getText());
        radioButtonF.setActionCommand(radioButtonF.getText());

        fieldKelamin = new ButtonGroup();
        fieldKelamin.add(radioButtonM);
        fieldKelamin.add(radioButtonF);

        panel.add(radioButtonM);
        panel.add(radioButtonF);

        return panel;
    }

    private JDatePanelImpl createDatePanel() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel;
        datePanel = new JDatePanelImpl(model, p);

        return datePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Submit":
                if(!RegisterController.validatingAllInput(fieldNama.getText(),
                fieldLahir.getModel().getValue(),
                fieldBuat.getModel().getValue(),
                fieldKelamin.getSelection(),
                fieldFoto.getSelectedFile())){
                JOptionPane.showMessageDialog(null, "Field masih ada yang kosong !", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println("haha");
                    if(RegisterController.registering(fieldNama.getText(),
                            fieldLahir.getModel().getValue(),
                            fieldBuat.getModel().getValue(),
                            fieldKelamin.getSelection().getActionCommand(),
                            fieldFoto.getSelectedFile())){

                        System.out.println("haha");

                        int id = GetDataMember.getMemberNumber();
                        new ViewPage(id);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Register Gagal !", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Exit":
                new HomePage();
                this.dispose();
                break;
        }
        System.out.println(command);
    }
}
