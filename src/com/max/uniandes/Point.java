package com.max.uniandes;

import java.math.BigInteger;

public class Point {

    private BigInteger x;
    private BigInteger y;

    Point() {
    }

    public BigInteger getX() {
        return x;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[ " + x + ", " + y + " ]";
    }
}
