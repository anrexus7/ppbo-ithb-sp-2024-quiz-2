package view;

import javax.swing.*;
import java.awt.*;

public class SearchPage extends JFrame {
    public SearchPage() {
        innit();
    }

    public void innit() {
        String search = JOptionPane.showInputDialog(null, "Masukkan nomor anggota ");

        if(search == null){
            new HomePage();
        }else{
            int searching = Integer.parseInt(search);
            new ViewPage(searching);
        }
    }
}
