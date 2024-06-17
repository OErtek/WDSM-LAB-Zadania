package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorHistory {
    private List<String> history = new ArrayList<>();

    public void addHistory(String entry) {
        history.add(entry);
    }

    public List<String> getHistory() {
        return history;
    }
}
