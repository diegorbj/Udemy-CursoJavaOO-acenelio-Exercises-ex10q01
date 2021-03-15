package aplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int lines = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();
        System.out.println("[" + lines + ", " + columns + "]");

        int[][] matrix = new int[lines][columns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter a number to find: ");
        int pivot = sc.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == pivot) {
                    System.out.println("Position (" + i + "," + j + "):");
                    printContent(matrix, i, j-1, "Left");
                    printContent(matrix, i, j+1, "Right");
                    printContent(matrix, i-1, j, "Up");
                    printContent(matrix, i+1, j, "Down");
                }
            }
        }

        sc.close();
    }

    private static void printContent(int[][] matrix, int i, int j, String message){
        Integer c;

        c = content(matrix, i, j);
        if (c != null) { System.out.println(message + ": " + c); }
    }

    private static Integer content(int[][] matrix, int i, int j) {
        if (i >= 0 && i < matrix.length) {
            if (j >= 0 && j < matrix[i].length) {
                return matrix[i][j];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
