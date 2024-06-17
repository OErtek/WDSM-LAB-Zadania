package com.example.gui;

import com.example.calculator.CalculatorHistory;

import javax.swing.*;
import java.awt.*;

public class HistoryWindow {
    private JFrame frame;
    private JTextArea historyArea;

    public HistoryWindow(CalculatorHistory history) {
        initialize(history);
    }

    private void initialize(CalculatorHistory history) {
        frame = new JFrame("History");
        frame.setSize(300, 400);

        historyArea = new JTextArea();
        historyArea.setEditable(false);
        for (String entry : history.getHistory()) {
            historyArea.append(entry + "");
        }
        frame.add(new JScrollPane(historyArea), BorderLayout.CENTER);

        frame.setVisible(false);
    }

    public void show() {
        frame.setVisible(true);
    }
}
