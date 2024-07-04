package view;

import javax.swing.*;
import java.awt.*;

public class SearchPage extends JFrame {
    public SearchPage() {
        innit();
    }

    public void innit() {
        String search = JOptionPane.showInputDialog(null, "Masukkan nomor anggota ");
        int searching = Integer.parseInt(search);

        if(search == null){
            new HomePage();
        }else{
            new ViewPage(searching);
        }
    }
}
