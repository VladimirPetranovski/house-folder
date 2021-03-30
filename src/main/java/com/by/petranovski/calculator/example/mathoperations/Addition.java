package com.by.petranovski.calculator.example.mathoperations;

public class Addition implements MathematicalOperation{
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
