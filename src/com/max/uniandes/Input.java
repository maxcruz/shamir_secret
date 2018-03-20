package com.max.uniandes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private final Scanner scanner;

    Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int captureInteger(String message, Condition condition) {
        boolean done = false;
        int capture = 0;
        while (! done) {
            if (message != null) System.out.print(message);
            try {
                capture = scanner.nextInt();
                if (condition == null || condition.validate(capture)) {
                    done = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong number. Try again");
            }
            System.out.println("");
        }
        return capture;
    }

    public ArrayList<Point> capturePoints(long prime) {
        while (true) {
            int shares = captureInteger("Required points (k < p): ", number -> (number < prime));
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < shares; i++) {
                Point point = new Point();
                int x = captureInteger("Row["+i+"] X: ", number -> true);
                point.setX(BigInteger.valueOf(x));
                int y = captureInteger("Row["+i+"] Y: ", number -> true);
                point.setY(BigInteger.valueOf(y));
                points.add(point);
            }
            System.out.println(points.toString());
            System.out.print("Is the list of points okay? (y/n): ");
            String isOk = scanner.next();
            if (isOk != null && "y".equals(isOk.toLowerCase())) return points;
        }
    }

    interface Condition {

        boolean validate(int number);

    }

}
