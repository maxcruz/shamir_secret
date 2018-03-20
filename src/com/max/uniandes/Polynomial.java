package com.max.uniandes;

import java.util.List;

class Polynomial {

    private List<Integer> coefficients;

    Polynomial(List<Integer> coefficients) {
        this.coefficients = coefficients;
    }

    public int evaluate(int x) {
        int result = 0;
        for (int i = coefficients.size() - 1; i>= 0; i--) {
            result *= x;
            result += coefficients.get(i);
        }
        return result;
    }

}