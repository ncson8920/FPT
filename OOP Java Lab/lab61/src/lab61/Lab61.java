/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab61;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab61 {

    /**
     * @param args the command line arguments
     */
     private static final Scanner in = new Scanner(System.in);

    private double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    private Triangle inputTriangle() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }

    }

    private Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    private Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        Lab61 l= new Lab61();
        Rectangle rectangle = l.inputRectangle();
        Circle circle = l.inputCircle();
        Triangle trigle = l.inputTriangle();

       // display(trigle, rectangle, circle);
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
    
}
