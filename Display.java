import javax.swing.*;
import java.awt.*;

public class Display extends JTextField {
    Display() {
        this.setBackground(Color.BLACK);
        this.setSize(100,100);
        this.setFont(new Font("default", Font.PLAIN, 24));
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(JTextField.RIGHT);
        this.setBounds(50, 10, 400, 50);
        this.setEditable(false);
    }
}