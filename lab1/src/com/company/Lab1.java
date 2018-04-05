package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Type n");
            byte n = scan.nextByte();
            if (n < 0){
                throw new IllegalArgumentException();
            }
            System.out.println("Type M");
            byte m = scan.nextByte();
            if (m < 0){
                throw new IllegalArgumentException();
            }
            double s = 0;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    s = s + (i * j) / (float)(i + 1);
                }
            }
            System.out.println(s);
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Input Incorrect");
        } catch (IllegalArgumentException illegalInput){
            System.out.println("N and M should be > 0");
        }
    }
}