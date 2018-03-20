package com.max.uniandes;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Input input = new Input(scanner);

        while (true) {
            System.out.println("==============================");
            System.out.println("|   Shamir's Secret Sharing  |");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("Select and option (1,2):");
            System.out.println("[1] Reveal a secret");
            System.out.println("[2] Hide a secret");
            System.out.println("[3] Quit");

            int option = input.captureInteger(null, number -> (number >= 1 && number <= 3));

            if (option == 3) {
                System.out.println("Bye");
                break;
            }

            int prime = input.captureInteger("Prime number (p): ",
                    number -> BigInteger.valueOf(number).isProbablePrime(100));

            SecretSharing secretSharing = new SecretSharing(BigInteger.valueOf(prime));

            if (option == 1) {
                performReveal(secretSharing, input);
            } else if (option == 2) {
                performHide(secretSharing, input);
            }

            System.out.println("");
        }
    }

    private static void performReveal(SecretSharing secretSharing, Input input) {
        List<Point> shares = input.capturePoints(secretSharing.getPrime().longValue());
        BigInteger secret = secretSharing.revealSecret(shares);
        System.out.println("");
        System.out.println("The secret is: " + secret);
    }

    private static void performHide(SecretSharing secretSharing, Input input) {
        long p = secretSharing.getPrime().longValue();
        int total = input.captureInteger("Points to generate (n < p): ", number -> (number < p));
        int required = input.captureInteger("Minimum required points (k < n): ", number -> (number < total));
        int secret = input.captureInteger("Tell me the secret (s < p): ", number -> (number < p));
        List<Point> shares = secretSharing.hideSecret(total, required, secret);
        System.out.print("Shares: ");
        System.out.println(shares);
    }

}
