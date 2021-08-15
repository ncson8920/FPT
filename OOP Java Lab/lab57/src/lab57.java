
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
public class lab57 {

    Scanner scan = new Scanner(System.in);

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

    public void write(user t) {
        try {
            File f = new File("user.dat");
            FileOutputStream fo;
            ObjectOutputStream oStream = null;
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else {
                if (!hasObject(f)) {
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
            }
            oStream.writeObject(t);
            oStream.close();
            fo.close();
        } catch (IOException e) {
        }
    }

    public void read(List<user> list) {
        try {
            File f = new File("user.dat");
            try (FileInputStream fis = new FileInputStream(f); ObjectInputStream inStream = new ObjectInputStream(fis)) {
                user t;
                while ((t = (user) inStream.readObject()) != null) {
                    list.add(t);
                }
            }
        } catch (ClassNotFoundException | IOException e) {
        }
    }

    public int getINT(int MIN, int MAX) {
        while (true) {
            try {
                int number = Integer.parseInt(scan.nextLine());
                if (number < MIN || number > MAX) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Enter range [" + MIN + ", " + MAX + "]");
            }
        }
    }

    public boolean checkSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isSpaceChar(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public String getString(String MSG, int number) {
        while (true) {
            System.out.print(MSG);
            String str = scan.nextLine();
            char[] toCharArray = str.toCharArray();
            if (str.isEmpty()) {
                System.out.println("Not empty!");
            } else if (toCharArray.length < number || checkSpace(str)) {
                System.out.println("you must enter least at " + number + " character, and no space!");
            } else {
                return str;
            }
        }
    }

    public void addAccount() {
        List<user> acc = new ArrayList<>();
        read(acc);
        String username = getString("acc: ", 5);
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i).getUsername().equalsIgnoreCase(username)) {
                System.out.println("user exist");
                return;
            }
        }
        String pass = getString("pass: ", 6);
        write(new user(username, pass));
        System.out.println("add success");
    }

    public void login() {
        List<user> acc = new ArrayList<>();
        read(acc);
        String username = getString("acc: ", 5);
        String pass = getString("pass: ", 6);
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i).getUsername().equals(username) && acc.get(i).getPassword().equals(pass)) {
                System.out.println("login success");
                return;
            }   
        }
         System.out.println("Invalid user name or password");
    }

    public void showMenu() {
        System.out.println("1. create new");
        System.out.println("2. login");
        System.out.println("3. exit");
        System.out.println(">choose: ");
    }

    public static void main(String[] args) {
        lab57 l = new lab57();
        while (true) {
            l.showMenu();
            int choice = l.getINT(1, 3);
            switch (choice) {
                case 1:
                    l.addAccount();
                    break;
                case 2:
                    l.login();
                    break;
                case 3:
                    return;
            }
        }
    }
}
