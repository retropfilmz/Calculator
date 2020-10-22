import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class MainCalculator {

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

    public MainCalculator() {
        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entered = '(' + textInput1.getText() + ')';
                String myresult = "";
                myresult = infixToPostfix(entered);
                result.setText(myresult);
            }
        });

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 0);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 1);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 2);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 3);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 4);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 5);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 6);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 7);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 8);
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + 9);
            }
        });

        buttonDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '.');
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '+');
            }
        });

        buttonSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '-');
            }
        });

        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '*');
            }
        });

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '/');
            }
        });

        buttonExponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "^(");
            }
        });

        buttonNaturalLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "ln(");
            }
        });

        buttonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "log(");
            }
        });

        buttonSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "sin(");
            }
        });

        buttonCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "cos(");
            }
        });

        buttonTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "tan(");
            }
        });

        buttonCot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + "cot(");
            }
        });

        buttonRParenth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + ')');
            }
        });

        buttonLParenth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput1.setText(textInput1.getText() + '(');
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput1.getText();
                textInput1.setText(text.substring(0, text.length() - 1));
            }
        });


    }

    public static String infixToPostfix(String expression) {
        // ----- Check for syntactical errors -----
        // Remove spaces
        if (expression.contains(" "))
        {
            String newExpression = expression.replaceAll(" ", "");
            expression = newExpression;
        }

        // Check for correct parentheses placement
        int lp = 1, rp = 0;
        String errorMessage = "";
        for (int i = 1; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(') lp++;
            if (expression.charAt(i) == ')') rp++;

            if (lp == rp && i < expression.length()-1)
            {
                // Error extra parentheses
                errorMessage = "Error: Extra parentheses";
                return errorMessage;
            }
            else if (lp < rp)
            {
                // Error misplaced closing parentheses
                errorMessage = "Error: Misplaced closing parentheses";
                return errorMessage;
            }
            else if (lp > rp && i == expression.length()-1)
            {
                // Error missing closing parentheses
                errorMessage = "Error: Missing closing parentheses";
                return errorMessage;
            }
        }

        // Add implied multiplication
        String impliedMulOptions = "123456789.)";
        for (int i = 1; i < expression.length(); i++)
        {
            char c = expression.charAt(i);
            String prevChar = "";
            prevChar += expression.charAt(i-1);
            if (c == '(')
            {
                if (impliedMulOptions.contains(prevChar))
                {
                    String pre = expression.substring(0, i);
                    String post = expression.substring(i);
                    expression = pre + '*' + post;
                }
            }
        }

        // Handle functions within the expression
        while (expression.contains("s") || expression.contains("c") || expression.contains("t") || expression.contains("l")) {
            if (expression.charAt(0) == 'E') return expression;
            expression = functionPresent(expression);
        }


        // ----- Create RPN -----
        // Variables to store results
        Stack<String> rpn = new Stack<String>();
        Stack<String> stack = new Stack<String>();

        // Define all operators possible in the question
        String operators = "^*/+-()";

        for (int pos = 0; pos < expression.length(); pos++) {
            char c = expression.charAt(pos);

            // If a number, find the end of it and add to stack
            if (Character.isDigit(c)) {
                int endpos = 0;
                for (int i = pos; i < expression.length(); i++) {
                    char seekChar = expression.charAt(i);
                    if (Character.isDigit(seekChar) || seekChar == '.') {
                        continue;
                    } else {
                        endpos = i;
                        break;
                    }
                }
                rpn.push(expression.substring(pos, endpos));
                pos = endpos - 1;
                continue;
            }

            // If a negative number, find end of it and add to stack
            if (c == '-' && operators.contains(expression.substring(pos-1, pos)))
            {
                int endpos = 0;
                for (int i = pos; i < expression.length(); i++) {
                    char seekChar = expression.charAt(i);
                    if (Character.isDigit(seekChar) || seekChar == '.' || seekChar == '-') {
                        continue;
                    } else {
                        endpos = i;
                        break;
                    }
                }
                rpn.push(expression.substring(pos, endpos));
                pos = endpos - 1;
                continue;
            }

            // If opening a set of parentheses, push it to stack.
            if (c == '(') {
                stack.push("(");
                continue;
            }

            // If closing a set of parentheses, pop to rpn until opening parentheses occurs.
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != "(") {
                    rpn.push(stack.pop());
                }
                // Once we hit the open parentheses, pop it and exit loop
                stack.pop();
                continue;
            }

            // When an operand has been found
            else {
                while (!stack.isEmpty() && pemdas(c) <= pemdas(stack.peek())) {
                    rpn.push(stack.pop());
                }
                String operandString = new String();
                operandString += c;
                stack.push(operandString);
            }

        }

        // ----- Solve RPN -----
        // Grab the RPN from the stack and turn it into an array to access it properly
        String[] rpnArray = new String[rpn.size()];
        for (int i = rpn.size() - 1; i > -1; i--) {
            rpnArray[i] = rpn.pop();
        }

        // If array is just one number, return it
        if (rpnArray.length == 1) return rpnArray[0];



        // Create stack for solving the problem
        Stack<String> solvingStack = new Stack<String>();

        for (int i = 0; i < rpnArray.length; i++) {
            // If it is a number, add to stack
            if (!operators.contains(rpnArray[i])) {
                solvingStack.push(rpnArray[i]);
                continue;
            }
            else if (rpnArray[i].charAt(0) == '-' && rpnArray[i].length() > 1)
            {
                solvingStack.push(rpnArray[i]);
                continue;
            }
            // Otherwise we do the math
            else
            {
                // Popping B first because of subtraction, division, and exponent
                double b = Double.parseDouble(solvingStack.pop());
                double a = Double.parseDouble(solvingStack.pop());
                int operator = operators.indexOf(rpnArray[i]);
                double result = 0;
                String resultStr = new String();
                switch (operator) {
                    // Exponent
                    case 0:
                        result = Math.pow(a, b);
                        break;

                    // Multiplication
                    case 1:
                        result = (a * b);
                        break;

                    // Division
                    case 2:
                        if (b == 0) return "Error: Cannot divide by zero";
                        result = (a / b);
                        break;

                    // Addition
                    case 3:
                        result = (a + b);
                        break;

                    // Subtraction
                    case 4:
                        result = (a - b);
                        break;
                }
                resultStr += result;
                solvingStack.push(resultStr);
            }
        }


        //double answer = Double.parseDouble(solvingStack.pop());
        return solvingStack.pop();
    }

    public static String functionPresent(String expression) {
        int preend = expression.length(), currentend = expression.length();
        String pre, current, post;

        // Find the start of the expression
        for (int i = 0; 0 < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == 's' || c == 'c' || c == 't' || c == 'l') {
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
        for (int i = start; i < current.length(); i++) {
            if (lpar == rpar) break;
            if (current.charAt(i) == '(') lpar++;
            if (current.charAt(i) == ')') {
                currentend = i;
                rpar++;
            }
        }

        // Chop off portion that is outside of parentheses
        post = current.substring(currentend + 1);
        if (post.length() == 0) post += ')';
        current = current.substring(0, currentend + 1);
        double newCurrent = 0;
        double calculated =0;

        // Evaluate "current"
        switch (current.charAt(0)) {
            case 's':
                // Sin
                calculated = Double.parseDouble(infixToPostfix(current.substring(3)));
                newCurrent = Math.sin(calculated);
                break;
            case 'c':
                // Cos
                if (current.charAt(2) == 's')
                {
                    calculated = Double.parseDouble(infixToPostfix(current.substring(3)));
                    newCurrent = Math.cos(calculated);
                    break;
                }
                // Cot
                if (current.charAt(2) == 't')
                {
                    calculated = Double.parseDouble(infixToPostfix(current.substring(3)));
                    double tanVal = Math.tan(calculated);
                    if (tanVal == 0) return "Error: tan was 0, cannot divide by zero";
                    newCurrent = 1 / tanVal;
                    break;
                }
            case 't':
                // Tan
                calculated = Double.parseDouble(infixToPostfix(current.substring(3)));
                newCurrent = Math.tan(calculated);
                break;
            case 'l':
                // Log

                if (current.charAt(1) == 'o')
                {
                    calculated = Double.parseDouble(infixToPostfix(current.substring(3)));
                    if (calculated <= 0) return "Error: Log is not defined < 0";
                    newCurrent = Math.log10(calculated);
                    break;
                }
                // Ln

                if (current.charAt(1) == 'n')
                {
                    calculated = Double.parseDouble(infixToPostfix(current.substring(2)));
                    if (calculated <= 0) return "Error: Ln is not defined < 0";
                    newCurrent = Math.log(calculated);
                    break;
                }
            default:
                // This should not be reachable.

        }

        //Put string back together and send it back
        String newString = pre + newCurrent + post;
        return newString;

    }

    public static int pemdas(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    public static int pemdas(String s) {
        char c = s.charAt(0);
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainCalculator().gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
