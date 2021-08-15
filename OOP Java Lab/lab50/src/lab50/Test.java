/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Test {

    private static final Scanner in = new Scanner(System.in);

    //dispaly menu
    public int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
        return choice;
    }

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input double
    public float checkInputDouble(String mes) {
        //loop until user input correct
        while (true) {
            System.out.print(mes);
            try {
                float result = Float.parseFloat(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
            }

        }
    }

    //check number is even or not
    public boolean checkEven(float n) {
        return n % 2 == 0;
    }

    //check number is squarenumber or not
    public boolean checkSquareNumber(float n) {

        if ((int) n != 0) {
            return (int) Math.sqrt(n) * (int) Math.sqrt(n) == n;
        }
        return false;

    }

    //check number is odd or not
    public boolean checkOdd(float n) {
        return n % 2 == 1 || checkEven(n) == false && checkSquareNumber(n) == false;
    }

    public List<Float> calculateEquation(float a, float b) {

        List<Float> list = new ArrayList<Float>();
        if (a == 0) {
            if (b == 0) {
                return Collections.EMPTY_LIST;
            } else {
                return list = null;
            }
        } else {
            if (b == 0) {
                float x = 0;
                list.add(x);
                return list;
            } else {
                float x = -b / a;
                list.add(x);
                return list;
            }
        }

    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> list = new ArrayList<Float>();
        float x1 = 0;
        float x2 = 0;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return Collections.EMPTY_LIST;
                } else {
                    return list = null;
                }
            } else {
                if (c == 0) {
                    x1 = x2 = 0;
                    list.add(x1);
                    list.add(x2);
                    return list;
                } else {
                    x1 = x2 = -c / b;
                    list.add(x1);
                    list.add(x2);
                    return list;
                }
            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                list.add(x1);
                list.add(x2);
                return list;
            } else if (delta == 0) {
                if (b == 0) {
                    x1 = x2 = 0;
                    list.add(x1);
                    list.add(x2);
                    return list;
                } else {
                    x1 = x2 = -b / (2 * a);
                    list.add(x1);
                    list.add(x2);
                    return list;
                }
            } else {
                return list = null;
            }
        }
    }

    public void checkodd(List<Float> oList) {
        List<Float> listodd = new ArrayList<Float>();
        for (int i = 0; i < oList.size(); i++) {
            if (checkOdd(oList.get(i))) {
                listodd.add((Float) oList.get(i));
            }

        }
        System.out.print("Number is odd:");
        for (int i = 0; i < listodd.size(); i++) {
            System.out.print(listodd.get(i));
            if (i < listodd.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void checkeven(List<Float> oList) {
        List<Float> listeven = new ArrayList<Float>();
        for (int i = 0; i < oList.size(); i++) {
            if (checkEven(oList.get(i))) {
                listeven.add((Float) oList.get(i));
            }

        }
        System.out.print("Number is even:");
        for (int i = 0; i < listeven.size(); i++) {
            System.out.print(listeven.get(i));
            if (i < listeven.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void checksquare(List<Float> oList) {
        List<Float> listsquare = new ArrayList<Float>();
        for (int i = 0; i < oList.size(); i++) {
            if (checkSquareNumber(oList.get(i))) {
                listsquare.add((Float) oList.get(i));
            }

        }
        System.out.print("Number is square:");
        for (int i = 0; i < listsquare.size(); i++) {
            System.out.print(listsquare.get(i));
            if (i < listsquare.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    //allow user calculate Superlative Equation
    public void superlativeEquation() {
        List<Float> list;

        float a = checkInputDouble("Enter A: ");

        float b = checkInputDouble("Enter B: ");
        list = calculateEquation(a, b);
        List<Float> result = new ArrayList<>();
        if (list == null) {
            System.out.println("equation has infinitely many solutions");
            result.add(a);
            result.add(b);
            checkeven(result);
            checkodd(result);
            checksquare(result);
        } else if (list.isEmpty()) {
            System.out.println("equation has no solutions");
            result.add(a);
            result.add(b);
            checkeven(result);
            checkodd(result);
            checksquare(result);
        } else {
            System.out.println("Solution: x =" + list.get(0));
            result.add(a);
            result.add(b);
            result.add(list.get(0));
            checkeven(result);
            checkodd(result);
            checksquare(result);
        }

    }

    //allow user calculate Quadratic Equation
    public void quadraticEquation() {
        List<Float> list;

        float a = checkInputDouble("Enter A: ");

        float b = checkInputDouble("Enter B: ");

        float c = checkInputDouble("Enter C: ");
        list = calculateQuadraticEquation(a, b, c);
        List<Float> result = new ArrayList<>();
        if (list == null) {
            System.out.println("equation has infinitely many solutions");
            result.add(a);
            result.add(b);
            result.add(c);
            checkeven(result);
            checkodd(result);
            checksquare(result);
        } else if (list.isEmpty()) {
            System.out.println("equation has no solutions");
            result.add(a);
            result.add(b);
            result.add(c);
            checkeven(result);
            checkodd(result);
            checksquare(result);
        } else {
            System.out.println("Solution: x1 = " + list.get(0) + " and x2 = " + list.get(1));
            
            result.add(a);
            result.add(b);
            result.add(c);
            result.add(list.get(0));
            result.add(list.get(1));
            checkeven(result);
            checkodd(result);
            checksquare(result);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //loop until user want to exit
        Test Manager = new Test();
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.superlativeEquation();
                    break;
                case 2:
                    Manager.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }
}
