/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab74;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Test {

    private Scanner in = new Scanner(System.in);

    private int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private int checkInputElement() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }

    }

    private int[][] inputMatrix(String mes, int[][] matrixInput, int number, String operator) {
        if (!mes.isEmpty()) {
            System.out.println(mes);
        }
        int rowmatrix = 0;
        int colmatrix = 0;
        if (matrixInput != null) {
            rowmatrix = matrixInput.length;
            colmatrix = matrixInput[0].length;
        }

        int row;
        while (true) {
            System.out.print("Enter Row Matrix " + number + ":");
            try {
                row = checkInputElement();
                if (number == 1) {
                    if (row > 0) {
                        break;
                    } else {
                        System.out.println("Row must be positive integer");
                    }
                } else {
                    if (operator.equals("+") || operator.equals("-")) {
                        if (row == rowmatrix) {
                            break;
                        } else {
                            System.out.println("Row of matrix2 must equal than row of matrix1");
                        }
                    } else {
                        if (row == colmatrix) {
                            break;
                        } else {
                            System.out.println("Row of matrix2 must equal than colume of matrix1");
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Row must be integer");
            }
        }

        int col;
        while (true) {
            System.out.print("Enter Colum Matrix " + number + ":");
            try {
                col = checkInputElement();
                if (number == 1) {
                    if (col > 0) {
                        break;
                    } else {
                        System.out.println("Colume must be positive integer");
                    }
                } else {
                    if (operator.equals("+") || operator.equals("-")) {
                        if (col == colmatrix) {
                            break;
                        } else {
                            System.out.println("Colume of matrix2 must equal than Colume of matrix1");
                        }
                    } else {
                        if (col > 0) {
                            break;
                        } else {
                            System.out.println("Colume must be positive integer");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Colume must be integer");
            }
        }
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + number + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = checkInputElement();
            }
        }
        return matrix;
    }

    private void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int rowmt1 = matrix1.length;
        int colmx1 = matrix1[0].length;
        int rowmt2 = matrix2.length;
        int colmx2 = matrix2[0].length;
        int[][] matrixResult = new int[rowmt1][colmx2];

        for (int i = 0; i < rowmt1; i++) {
            for (int j = 0; j < colmx2; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return matrixResult;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int rowmt1 = matrix1.length;
        int colmx1 = matrix1[0].length;
        int rowmt2 = matrix2.length;
        int colmx2 = matrix2[0].length;
        int[][] matrixResult = new int[rowmt1][colmx2];

        for (int i = 0; i < rowmt1; i++) {
            for (int j = 0; j < colmx2; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return matrixResult;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int rowmt1 = matrix1.length;
        int colmx1 = matrix1[0].length;
        int rowmt2 = matrix2.length;
        int colmx2 = matrix2[0].length;
        int[][] matrixResult = new int[rowmt1][colmx2];

        for (int i = 0; i < rowmt1; i++) {
            for (int j = 0; j < colmx2; j++) {
                matrixResult[i][j] = 0;
            }
        }

        for (int i = 0; i < rowmt1; i++) {
            for (int j = 0; j < colmx2; j++) {
                for (int k = 0; k < colmx1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return matrixResult;
    }

    public void DisplayResult(String operator, int[][] matrix1, int[][] matrix2, int[][] matrixResult) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println(operator);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(matrixResult);

    }

    public void display() {
        System.out.println("");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");

    }

    public static void main(String[] args) {
        Test l = new Test();
        while (true) {
            l.display();
            int choice = l.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    int[][] matrixadd1 = l.inputMatrix("-------- Addition --------", null, 1, "+");
                    int[][] matrixadd2 = l.inputMatrix("", matrixadd1, 2, "+");
                    int[][] matrixaddresult = l.additionMatrix(matrixadd1, matrixadd2);
                    l.DisplayResult("+", matrixadd1, matrixadd2, matrixaddresult);
                    break;
                case 2:
                    int[][] matrixsub1 = l.inputMatrix("----- Subtraction ------", null, 1, "-");
                    int[][] matrixsub2 = l.inputMatrix("", matrixsub1, 2, "-");
                    int[][] matrixsubresult = l.subtractionMatrix(matrixsub1, matrixsub2);
                    l.DisplayResult("-", matrixsub1, matrixsub2, matrixsubresult);
                    break;
                case 3:
                    int[][] matrixmul1 = l.inputMatrix("-------- Multiplication -------", null, 1, "*");
                    int[][] matrixmul2 = l.inputMatrix("", matrixmul1, 2, "*");
                    int[][] matrixmulresult = l.multiplicationMatrix(matrixmul1, matrixmul2);
                    l.DisplayResult("*", matrixmul1, matrixmul2, matrixmulresult);
                    break;
                case 4:
                    return;
            }
        }

    }
}
