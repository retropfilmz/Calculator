import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCalculator
{

    private JPanel gui;
    private JTextField textInput1;
    private JButton buttonDelete;
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
    private JButton buttonLog;
    private JButton buttonSin;
    private JButton buttonCos;
    private JButton buttonTan;
    private JButton buttonCot;
    private JButton buttonRParenth;
    private JButton buttonLParenth;
    private JLabel result;

    public MainCalculator()
    {
        buttonEquals.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                //evaluateExpression();
                result.setText(textInput1.getText());
            }
        });

        button0.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 0);
            }
        });

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 1);
            }
        });

        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 2);
            }
        });

        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 3);
            }
        });

        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 4);
            }
        });

        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 5);
            }
        });

        button6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 6);
            }
        });

        button7.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 7);
            }
        });

        button8.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 8);
            }
        });

        button9.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 9);
            }
        });

        buttonDecimal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '.');
            }
        });

        buttonAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '+');
            }
        });

        buttonSubtract.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '-');
            }
        });

        buttonMultiply.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '*');
            }
        });

        buttonDivide.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '/');
            }
        });

        buttonExponent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "^(");
            }
        });

        buttonNaturalLog.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "ln(");
            }
        });

        buttonLog.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "log(");
            }
        });

        buttonSin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "sin(");
            }
        });

        buttonCos.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "cos(");
            }
        });

        buttonTan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "tan(");
            }
        });

        buttonCot.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "cot(");
            }
        });

        buttonRParenth.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + ')');
            }
        });

        buttonLParenth.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '(');
            }
        });


    }

    public static void evaluateExpression()
    {
        double answer;
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainCalculator().gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
