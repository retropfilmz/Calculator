import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCalculator {

    private JPanel gui;
    private JTextField textInput1;
    private JButton displayButton;
    private JButton button1;
    private JButton button4;
    private JButton button7;
    private JButton button0;
    private JButton buttonDecimal;
    private JButton button2;
    private JButton button5;
    private JButton button8;
    private JButton button9;
    private JButton button6;
    private JButton button3;
    private JButton buttonEquals;
    private JButton buttonAdd;
    private JButton buttonSubtract;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonExponent;
    private JButton buttonNaturalLog;
    private JButton logButton;
    private JButton buttonSin;
    private JButton buttonCos;
    private JButton buttonTan;
    private JButton buttonCot;
    private JButton buttonRParenth;
    private JButton buttonLParenth;
    private JLabel result;

    public MainCalculator() {
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(textInput1.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainCalculator().gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
