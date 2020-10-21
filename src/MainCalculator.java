import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

class Node
{
    public String data;
    public Node left;
    public Node right;
}

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
                String entered = '(' + textInput1.getText() + ')';
                double myresult;
                myresult = infixToPostfix(entered);
                String resultToPost = new String();
                resultToPost += myresult;
                result.setText(resultToPost);
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

        buttonDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput1.getText();
                textInput1.setText(text.substring(0, text.length() - 1));
            }
        });


    }

    public static double infixToPostfix(String expression)
    {
        // Check for syntactical errors


        // Handle functions within the expression
        while (expression.contains("s") || expression.contains("c") || expression.contains("t") || expression.contains("l"))
        {
            expression = functionPresent(expression);
        }

        // Stack for nodes
        Stack<Node> nodes = new Stack<Node>();

        // Stack for operators
        Stack<String> operators = new Stack<String>();

        double answer = 15;
        return answer;
    }

    public static String functionPresent(String expression){
        int preend = expression.length(), currentend = expression.length();
        String pre, current, post;

        // Find the start of the expression
        for (int i = 0; 0 < expression.length(); i++)
        {
            char c = expression.charAt(i);
            if (c == 's' || c == 'c' || c == 't' || c == 'l')
            {
                preend = i;
                break;
            }
        }

        // Save everything before expression in pre, and set current to remainder.
        pre = expression.substring(0, preend);
        if (pre.length() == 0) pre += '(';
        current = expression.substring(preend);

        // Find end of expression
        int lpar = 1;
        int rpar = 0;
        int start = current.indexOf('(') + 1;
        for (int i = start; i < current.length(); i++)
        {
            if (lpar == rpar) break;
            if (current.charAt(i) == '(') lpar++;
            if (current.charAt(i) == ')')
            {
                currentend = i;
                rpar++;
            }
        }

        // Chop off portion that is outside of parentheses
        post = current.substring(currentend+1);
        if (post.length() == 0) post += ')';
        current = current.substring(0, currentend+1);
        double newCurrent = 0;

        // Evaluate "current"
        switch (current.charAt(0)){
            case 's':
                // Sin
                newCurrent = Math.sin(infixToPostfix(current.substring(3)));
                break;
            case 'c':
                // Cos
                if (current.charAt(2) == 's') newCurrent = Math.cos(infixToPostfix(current.substring(3)));
                // Cot
                if (current.charAt(2) == 't') newCurrent = 1 / Math.tan(infixToPostfix(current.substring(3)));
                break;
            case 't':
                // Tan
                newCurrent = Math.tan(infixToPostfix(current.substring(3)));
                break;
            case 'l':
                // Log
                if (current.charAt(1) == 'o') newCurrent = Math.log(infixToPostfix(current.substring(3)));
                // Ln
                if (current.charAt(1) == 'n') newCurrent = Math.log(infixToPostfix(current.substring(2)));
                break;
            default:
                //There was an error this isn't good

        }

        //Put string back together and send it back
        String newString = pre + newCurrent + post;
        return newString;

    }

    public static void main(String[] args)
    {
        // DEBUG CODE
        String entered = "(sin(15)+15)";
        infixToPostfix(entered);
        // END DEBUG CODE

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainCalculator().gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
