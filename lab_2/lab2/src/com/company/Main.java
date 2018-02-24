package com.company;

public class Main {

    public static void main(String[] args) {
        final int n = 5, m = 5;
        final int a = 4;
        double aArray [][] = new double[n][m];
        System.out.println("A matrix:");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                aArray[i][j] = Math.random() * 100;
                System.out.printf("%-9.4f",aArray[i][j]);
            }
            System.out.print('\n');
        }
        System.out.println("C matrix:");
        double cArray [][] = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cArray[i][j] = aArray[i][j] * a;
                System.out.printf("%-9.4f",cArray[i][j]);
            }
            System.out.print('\n');
        }
        double maxInRow = Double.NEGATIVE_INFINITY, sumEven = 0, sumOdd = 0, minInRow = Double.POSITIVE_INFINITY;
        for (int i = 0; i < n; i+=2){
            for (int j =0; j < m; j++){
                if (cArray [i][j] > maxInRow) maxInRow = cArray[i][j];
            }
            sumOdd += maxInRow;
            maxInRow = Double.NEGATIVE_INFINITY;
        }
        for (int i = 1; i < n; i+=2) {
            for (int j = 0; j < m; j++) {
                if (cArray [i][j] < minInRow) minInRow = cArray[i][j];
            }
            sumEven += minInRow;
            minInRow = Double.POSITIVE_INFINITY;
        }
        System.out.printf("Even rows sum: %-10.4f\nOdd rows sum: %-10.4f", sumEven, sumOdd);
    }
}
