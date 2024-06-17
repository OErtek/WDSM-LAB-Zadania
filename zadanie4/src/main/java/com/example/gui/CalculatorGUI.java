package com.example.gui;

import com.example.calculator.Calculator;
import com.example.calculator.CalculatorHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField display;
    private Calculator calculator;
    private CalculatorHistory history;
    private StringBuilder currentInput;

    public CalculatorGUI() {
        calculator = new Calculator();
        history = new CalculatorHistory();
        currentInput = new StringBuilder();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "^", "C", "Bin", "Hex",
            "Oct", "Hist"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel);

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Buton işlemlerini burada gerçekleştirin
            if (command.equals("=")) {
                double result = calculator.evaluate(currentInput.toString());
                display.setText(String.valueOf(result));
                history.addHistory(currentInput.toString() + " = " + result);
                currentInput.setLength(0);
            } else if (command.equals("C")) {
                currentInput.setLength(0);
                display.setText("");
            } else if (command.equals("Hist")) {
                HistoryWindow historyWindow = new HistoryWindow(history);
                historyWindow.show();
            } else {
                currentInput.append(command);
                display.setText(currentInput.toString());
            }
        }
    }
}
