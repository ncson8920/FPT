/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

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
public class Lab71 {

    /**
     * @param args the command line arguments
     */
    
    

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

    public void write(Task t) {
        try {
            File f = new File("task.txt");
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

    public void read(List<Task> list) {
        try {
            File f = new File("task.txt");
            try (FileInputStream fis = new FileInputStream(f); ObjectInputStream inStream = new ObjectInputStream(fis)) {
                Task t;
                while ((t = (Task) inStream.readObject()) != null) {
                    list.add(t);
                }
            }
        } catch (ClassNotFoundException | IOException e) {
        }
    }
    
    Scanner scan = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public String getString(String tittle, String MSG) {
        if (!tittle.isEmpty()) {
            System.out.println(tittle);
        }
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

    public String getDeleteId() {
        System.out.println("---------Del Task------");
        while (true) {
            try {
                System.out.print("ID: ");
                int number = Integer.parseInt(scan.nextLine());
                if (number > 0) {
                    return String.valueOf(number);
                } else {
                    System.err.println("Enter an integer greater than zero");
                }
            } catch (NumberFormatException e) {
                System.err.println("Enter an integer number");
            }
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
                System.err.println("Enter range [" + MIN + ", " + MAX + "]");
            }
        }
    }

    Date getDate(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(scan.nextLine());
                return date;
            } catch (ParseException e) {
                System.err.println("Wrong date! Format date is dd-MM-yyy.");
            }
        }
    }

    private boolean checkTime(double r) {
        return r - (int) r == 0 || r - (int) r == 0.5;
    }

    private String checkInputPlan(String msg) {
        while (true) {
            System.out.print(msg);
            String result = scan.nextLine();
            double t = 0;
            try {
                t = Double.parseDouble(result);
                if (checkTime(t) && t >= 8.0
                        && t <= 17.5) {
                    return result;
                } else {
                    System.err.println("Please input time is double in range[8, 17.5]");
                }
            } catch (Exception e) {
                System.out.println("Please input time is double");
            }

        }
    }

    private String checkInputTaskTypeId(String msg) {
        while (true) {
            System.out.print(msg);
            int n = getINT(1, 4);
            String result = "";
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

    public int addTask(String requirementName, String assign, String date,
            String planFrom, String taskTypeID, String planTo, String reviewer)
            throws Exception {
        List<Task> list = new ArrayList<>();
        read(list);
        for (int i = 0; i < list.size(); i++) {
            if (requirementName.equals(list.get(i).getRequirementName())
                    && date.equals(list.get(i).getDate())
                    && planFrom.equals(list.get(i).getPlanFrom())
                    && planTo.equals(list.get(i).getPlanTo())
                    && taskTypeID.equals(list.get(i).getTaskTypeId())
                    && assign.equals(list.get(i).getassign())
                    && reviewer.equals(list.get(i).getreviewer())) {
                System.out.println("This task is exist");
                return -1;
            }
        }
        if (list.isEmpty()) {
            System.out.println("Add successfull");
            return 1;
        } else {
            int id = list.get(list.size() - 1).getId() + 1;
            System.out.println("Add successfull");
            return id;
        }

    }

    public void addTaskToFile(int id, String requirementName, String assign, String date,
            String planFrom, String taskTypeID, String planTo, String reviewer) {
        if (id != -1) {
            write(new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assign, reviewer));
        }
    }

    public void deleteTask(String id) {
        ArrayList<Task> list = new ArrayList<>();
        read(list);
        int number = Integer.parseInt(id);
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            Task t = list.get(i);
            if (t.getId() == number) {
                check = i;
            }
        }
        if (check != -1) {
            list.remove(check);
            System.out.println("Delete a task successful");
        } else {
            System.out.println("Delete a task fail");
        }
        try {
            File f = new File("task.txt");
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oStream = new ObjectOutputStream(fo);
            for (int i = 0; i < list.size(); i++) {
                oStream.writeObject(new Task(list.get(i).getId(), 
                list.get(i).getTaskTypeId(), list.get(i).getRequirementName(),
                        list.get(i).getDate(), list.get(i).getPlanFrom(), 
                        list.get(i).getPlanTo(), list.get(i).getassign(), 
                        list.get(i).getreviewer()));
            }
            oStream.close();
        } catch (IOException e) {
        }
    }

    public void getDataTasks() {
        List<Task> lt = new ArrayList<>();
        read(lt);
        System.out.println("21----------------------------------------- Task 19---------------------------------------");
        if (lt.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.printf("%-7s%-19s%-13s%-13s%-13s%-13s%-13s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-7d%-19s%-13s%-13s%-13.1f%-13s%-13s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    (Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom())),
                    lt.get(i).getassign(),
                    lt.get(i).getreviewer()
            );

        }
    }

    private void display() {
        System.out.println("========= Task program =========");
        System.out.println("   1. Add Task");
        System.out.println("   2. Delete task");
        System.out.println("   3. Display Task");
        System.out.println("   4. exit");
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Lab71 l = new Lab71();
        int choice;
        while (true) {
            l.display();
            choice = l.getINT(1, 4);
            switch (choice) {
                case 1:
                    String requirementName = l.getString("------------Add Task---------------",
                            "Requirement Name: ");
                    String taskTypeId = l.checkInputTaskTypeId("Task Type: ");
                    Date date = l.getDate("Date: ");
                    String planFrom = l.checkInputPlan("From: ");
                    String planTo = l.checkInputPlan("To: ");
                    String assign = l.getString("", "Assignee: ");
                    String reviewer = l.getString("", "Reviewer: ");
                    int id = l.addTask(requirementName, assign, dateFormat.format(date),
                            planFrom, taskTypeId, planTo, reviewer);
                    l.addTaskToFile(id, requirementName, assign, dateFormat.format(date),
                            planFrom, taskTypeId, planTo, reviewer);
                    break;
                case 2:
                    String deleteId = l.getDeleteId();
                    l.deleteTask(deleteId);
                    break;
                case 3:
                    l.getDataTasks();
                    break;
                case 4:
                    return;

            }
        }
    }
}
