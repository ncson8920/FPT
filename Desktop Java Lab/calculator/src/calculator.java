
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class calculator {

    private static final Scanner scanner = new Scanner(System.in);

    public int GetChoice() {
        int choice;
        while (true) {
            System.out.print("Enter your choice:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice <= 0 || choice > 3) {
                    System.err.println("Please enter number in range [1-3].");
                } else {
                    return choice;

                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter integer number in range [1-3].");

            }

        }

    }

    public double GetInputDouble() {
        double number;
        while (true) {
            System.out.print("Enter Number:");
            try {
                number = Double.parseDouble(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.err.print("Please enter number is double.");
            }

        }
    }

    public double GetInputBMI(String msg, String msgError) {
        double number;
        while (true) {
            System.out.print(msg);
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println(msgError);
                }

            } catch (NumberFormatException e) {
                System.out.print("BMI is digit");
            }

        }
    }

    public String GetInputOperator() {
        String operator;
        while (true) {
            System.out.println("Enter Operator:");
            operator = scanner.nextLine();
            if (operator.trim().isEmpty()) {
                System.err.println("Please Input (+, -, *, /, ^)");
                continue;
            }
            if (operator.trim().equalsIgnoreCase("+") || operator.trim().equalsIgnoreCase("-") || operator.trim().equalsIgnoreCase("*")
                    || operator.trim().equalsIgnoreCase("/") || operator.trim().equalsIgnoreCase("^") || operator.trim().equalsIgnoreCase("=")) {
                return operator;
            } else {
                System.err.println("Please Input (+, -, *, /, ^)");
            }
        }
    }

    public String GetBMICategory(double resultBMI) {
        if (resultBMI <= 19) {
            return "UNDER-STANDARD";
        } else if (resultBMI > 19 && resultBMI <= 25) {
            return "STANDARD";
        } else if (resultBMI > 25 && resultBMI <= 30) {
            return "FAT - SHOULD LOSE WEIGHT";
        } else {
            return "VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY";
        }
    }

    public void ShowMenu() {
        System.out.println("Caculator Program");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3.Exit");
    }

    public void CalculatorNormal() {
        double memory;
        String operator = "";
        System.out.println("Normal Calculator");
        memory = GetInputDouble();
        while (true) {
            operator = GetInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                double number = GetInputDouble();
                memory += number;
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("-")) {
                double number = GetInputDouble();
                memory -= number;
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("*")) {
                double number = GetInputDouble();
                memory *= number;
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("/")) {
                double number = GetInputDouble();
                if (number == 0) {
                    System.err.println("Can not div zero");
                } else {
                    memory = memory / number;
                }

                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("^")) {
                double number = GetInputDouble();
                memory = Math.pow(memory, number);
                System.out.println("Memory: " + memory);
            } else if (operator.equalsIgnoreCase("=")) {
                System.out.println("Memory: " + memory);
                break;
            }
        }
    }

    public void CalculatorBMI() {
        double weight;
        double height;
        double resultBMI;
        weight = GetInputBMI("Enter Weight(kg)", "Please enter the weight more than 0");
        height = GetInputBMI("Enter Height(cm)", "Please enter the height more than 0");
        resultBMI = weight * 10000 / (height * height);
        System.out.printf("BMI Number: %.2f\n", resultBMI);
        System.out.println("BMI Status: " + GetBMICategory(resultBMI));
    }

    public static void main(String[] args) {
        calculator calculator = new calculator();
        int choice;
        while (true) {
            calculator.ShowMenu();
            choice = calculator.GetChoice();
            switch (choice) {
                case 1:
                    calculator.CalculatorNormal();
                    break;
                case 2:
                    calculator.CalculatorBMI();
                    break;
                case 3:
                    return;
            }

        }
    }
}
