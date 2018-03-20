package com.max.uniandes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SecretSharing {

    private final BigInteger prime;

    SecretSharing(BigInteger prime) {
        this.prime = prime;
    }

    public List<Point> hideSecret(int total, int required, int secret) {
        List<Integer> coefficients = new ArrayList<>();
        coefficients.add(secret);
        for (int i = 0; i < (required - 1); i++) {
            int random = ThreadLocalRandom.current().nextInt(1, prime.intValue());
            coefficients.add(random);
        }
        Polynomial polynomial = new Polynomial(coefficients);
        List<Point> shares = new ArrayList<>();
        for (int i = 1; i < total + 1; i++) {
            Point point = new Point();
            point.setX(BigInteger.valueOf(i));
            point.setY(BigInteger.valueOf(polynomial.evaluate(i)).mod(prime));
            shares.add(point);
        }
        return shares;
    }

    public BigInteger revealSecret(List<Point> shares) {
        int required = shares.size();
        BigInteger secret = BigInteger.ZERO;
        for (int i = 0; i < required; i ++) {
            BigInteger products = BigInteger.ONE;
            for (int j = 0; j < required; j++) {
                if (i == j) continue;
                BigInteger subtract = shares.get(j).getX().subtract(shares.get(i).getX());
                subtract = subtract.modInverse(prime);
                products = products.multiply(shares.get(j).getX().multiply(subtract));
            }
            products = products.multiply(shares.get(i).getY());
            secret = secret.add(products);
        }
        return secret.mod(prime);
    }

    public BigInteger getPrime() {
        return prime;
    }

}
