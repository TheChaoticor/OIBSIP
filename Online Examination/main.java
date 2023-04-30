
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class main {
    public static void main(String[] args) {

        try {

            Online_Examination form = new Online_Examination();
            form.setSize(300, 287);
            form.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}



