/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab73;

import com.sun.swing.internal.plaf.metal.resources.metal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab73 {

    Scanner scan = new Scanner(System.in);
    SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy");
    SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd-MM-yyyy");

    public String getString(String MSG) {
        while (true) {
            System.out.print(MSG);
            String str = scan.nextLine();
            if (str.isEmpty()) {
                System.err.println("Not empty!");
            } else {
                return str;
            }
        }
    }

    public int getINT(String MSG, int MIN, int MAX) {
        while (true) {
            try {
                System.out.print(MSG);
                int number = Integer.parseInt(scan.nextLine());
                if (number < MIN || number > MAX) {
                    System.err.println("Enter range [" + MIN + ", " + MAX + "]");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter a positive integer number");
            }
        }
    }

    Date getDate(String MSG) {
        while (true) {
            try {
                dateFormatOut.setLenient(true);
                String mn= getString(MSG);
                Date date = dateFormatOut.parse(mn);
                String[] a= mn.split("-");
                if(!a[1].equalsIgnoreCase("Mar")){
                    System.out.println("date not exist ");
                }
                if(mn.equalsIgnoreCase(dateFormatOut.format(date))){
                    return date;}else{
                    System.out.println("date not exist");
                }
            } catch (ParseException e) {
                System.err.println("Wrong format date! Format date is dd-MMM-yyy.");
            }
        }
    }

    double getDouble(String MSG) {
        while (true) {
            try {
                System.out.print(MSG);
                double number = Double.parseDouble(scan.nextLine());
                if (number < 0) {
                    System.err.println("Enter a positive double number");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a double number");
            }
        }
    }

    public boolean hasObject(File f) {
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(f);
            try (ObjectInputStream inStream = new ObjectInputStream(fi)) {
                if (inStream.readObject() == null) {
                    check = false;
                }
            }
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException | ClassNotFoundException e) {
            check = false;
        }
        return check;
    }

    public void write(Expense s) {
        try {
            File f = new File("expense.txt");
            FileOutputStream fo;
            ObjectOutputStream oStream;
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else if (!hasObject(f)) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else {
                fo = new FileOutputStream(f, true);
                oStream = new ObjectOutputStream(fo) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }
            oStream.writeObject(s);
            oStream.close();
        } catch (IOException e) {
        }
    }

    public void read(List<Expense> list) {
        try {
            File f = new File("expense.txt");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fis);
            Expense ex;
            while ((ex = (Expense) inStream.readObject()) != null) {
                list.add(ex);
            }
        } catch (ClassNotFoundException | IOException e) {
        }
    }

    public void addExpense() {
        List<Expense> list = new ArrayList<>();
        read(list);
        System.out.println("-------- Add an expense --------");
        Date date = getDate("Enter Date: ");
        double amount = getDouble("Enter Amount: ");
        String content = getString("Enter Content: ");
        for (int i = 0; i < list.size(); i++) {
            if (dateFormatOut.format(date).equals(list.get(i).getDate())
                    && amount == list.get(i).getNumber()
                    && content.equals(list.get(i).getContent())) {
                System.out.println("This expense is exist");
                return;
            }
        }
        if (list.isEmpty()) {
            int id = 1;
            write(new Expense(id, dateFormatOut.format(date), amount, content));
            System.out.println("Add successfull");
        } else {
            int id = list.get(list.size() - 1).getId() + 1;
            write(new Expense(id, dateFormatOut.format(date), amount, content));
            System.out.println("Add successfull");
        }
    }

    public void displayAll() {
        List<Expense> list = new ArrayList<>();
        read(list);
        System.out.println("---------Display all expenses------------");
        if (list.isEmpty()) {
            System.out.println("List expenses is empty");
            return;
        }
        double total = 0;
        System.out.printf("%-6s%-14s%-10s%-1s\n", "ID", "Date", "Amount", "Content");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() % 2 == 0) {
                System.out.printf("%-6d%-14s%-10.0f%-11s\n", list.get(i).getId(),
                        list.get(i).getDate(), list.get(i).getNumber(), list.get(i).getContent());
            } else {
                System.out.printf("%-6d%-14s%-11.0f%-11s\n", list.get(i).getId(),
                        list.get(i).getDate(), list.get(i).getNumber(), list.get(i).getContent());
            }
            total += list.get(i).getNumber();
        }
        System.out.printf("%-13s%-14s%-15.0f\n", "", "Total:", total);
    }

    public void deleteExpense() {
        List<Expense> expenses = new ArrayList<>();
        read(expenses);
        System.out.println("--------Delete an expense------");
        int deid = getINT("Enter ID: ", 1, Integer.MAX_VALUE);
        int check = -1;
        for (int i = 0; i < expenses.size(); i++) {
            Expense exp = expenses.get(i);
            if (exp.getId() == deid) {
                check = i;
            }
        }
        if (check != -1) {
            expenses.remove(check);
            System.out.println("Delete an expense successful");
        } else {
            System.out.println("Delete an expense fail");
        }
        try {
            File f = new File("expense.txt");
            FileOutputStream fo = new FileOutputStream(f);
            try (ObjectOutputStream oStream = new ObjectOutputStream(fo)) {
                for (int i = 0; i < expenses.size(); i++) {
                    oStream.writeObject(new Expense(expenses.get(i).getId(),
                            expenses.get(i).getDate(), expenses.get(i).getNumber(),
                            expenses.get(i).getContent()));
                }
            }
        } catch (IOException e) {
        }
    }

    public void showMenu() {
        System.out.println("=======Handy Expense program======");
        System.out.println("1. Add an expenses");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }

    public static void main(String[] args) {
        Lab73 l = new Lab73();
        while (true) {
            l.showMenu();
            int choice = l.getINT("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    l.addExpense();
                    break;
                case 2:
                    l.displayAll();
                    break;
                case 3:
                    l.deleteExpense();
                    break;
                case 4:
                    return;
            }
        }
    }
}
