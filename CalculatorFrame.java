import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    Display display = new Display();
    JButton[] numbers = new JButton[10];
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    JButton equal = new JButton("=");
    JButton clear = new JButton("C");
    JButton dot = new JButton(".");
    JButton backspace = new JButton("del");
    //    JButton power = new JButton("x^");
//    JButton root = new JButton("x^1/2");
//    JButton log = new JButton();
//    JButton sin = new JButton();
//    JButton cos = new JButton();
//    JButton tan = new JButton();
//    JButton cot = new JButton();
//    JButton sec = new JButton();
//    JButton csc = new JButton();
//    JButton ln = new JButton();
//    JButton pi = new JButton();
//    JButton e = new JButton();
    CalculatorFrame() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton();
            numbers[i].setText(String.valueOf(i));
            numbers[i].setFocusable(false);
            numbers[i].addActionListener(this);
        }
        numbers[1].setBounds(50, 75, 50, 50);
        numbers[2].setBounds(100, 75, 50, 50);
        numbers[3].setBounds(150, 75, 50, 50);
        numbers[4].setBounds(50, 125, 50, 50);
        numbers[5].setBounds(100, 125, 50, 50);
        numbers[6].setBounds(150, 125, 50, 50);
        numbers[7].setBounds(50, 175, 50, 50);
        numbers[8].setBounds(100, 175, 50, 50);
        numbers[9].setBounds(150, 175, 50, 50);
        numbers[0].setBounds(50, 225, 50, 50);

        plus.setBounds(250, 75, 50, 50);
        plus.setFocusable(false);
        plus.addActionListener(this);

        minus.setBounds(300, 75, 50, 50);
        minus.setFocusable(false);
        minus.addActionListener(this);

        multiply.setBounds(350, 75, 50, 50);
        multiply.setFocusable(false);
        multiply.addActionListener(this);

        divide.setBounds(400, 75, 50, 50);
        divide.setFocusable(false);
        divide.addActionListener(this);

        equal.setBounds(250,125,50,50);
        equal.setFocusable(false);
        equal.addActionListener(this);

        clear.setBounds(300,125,50,50);
        clear.setFocusable(false);
        clear.addActionListener(this);

        dot.setBounds(100, 225, 40, 50);
        dot.setFocusable(false);
        dot.addActionListener(this);

        backspace.setBounds(140, 225, 60, 50);
        backspace.setText("del");
        backspace.setFocusable(false);
        backspace.addActionListener(this);

        this.setSize(500, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(display);
        for (JButton number : numbers) {
            this.add(number);
        }
        this.add(plus);
        this.add(minus);
        this.add(multiply);
        this.add(divide);
        this.add(dot);
        this.add(backspace);
        this.add(clear);
        this.add(equal);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton number : numbers) {
            if (e.getSource() == number) {
                display.setText(display.getText() + number.getText());
            }
        }
        if (e.getSource() == plus) {
            display.setText(display.getText() + plus.getText());
        }
        if (e.getSource() == minus) {
            display.setText(display.getText() + minus.getText());
        }
        if (e.getSource() == multiply) {
            display.setText(display.getText() + multiply.getText());
        }
        if (e.getSource() == divide) {
            display.setText(display.getText() + divide.getText());
        }
        if (e.getSource() == dot) {
            display.setText(display.getText() + dot.getText());
        }
        if (e.getSource() == backspace) {
            String text = display.getText();
            display.setText("");
            for (int i = 0; i < text.length() - 1; i++) {
                display.setText(display.getText() + text.charAt(i));
            }
        }
        if (e.getSource() == clear) {
            display.setText("");
        }
        if (e.getSource() == equal) {
            int c = 0;
            int num1 = 0;
            int num2 = 0;
            for(int i = 0; i< display.getText().length(); i++){
                if(!Character.isDigit(display.getText().charAt(i))){
                    num1 = Integer.parseInt(display.getText().substring(0,i));
                    num2 = Integer.parseInt(display.getText().substring(i+1));
                    c=i;
                    break;
                }
            }
            switch (display.getText().charAt(c)) {
                case '+' -> display.setText(String.valueOf(num1 + num2));
                case '-' -> display.setText(String.valueOf(num1 - num2));
                case '*' -> display.setText(String.valueOf(num1 * num2));
                case '/' -> display.setText(String.valueOf(num1 / num2));
            }
        }
    }
}