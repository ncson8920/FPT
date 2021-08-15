/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab65;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab65 {
    
    Scanner in = new Scanner(System.in);
    
    private String checkInputString(String info) {
        //loop until user input true value
        while (true) {
            System.out.print(info);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }
    
    private int checkInputMark(String nameSubject) {
        while (true) {
            try {
                System.out.print(nameSubject + ":");
                int result = Integer.parseInt(in.nextLine());
                if (result < 0) {
                    System.err.println(nameSubject + " is greater than equal zero");
                    //   System.out.print(nameSubject + ":");
                    continue;
                }
                if (result > 10) {
                    System.err.println(nameSubject + " is less than equal ten");
                    //  System.out.print(nameSubject + ":");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println(nameSubject + " is digit");
                
            }
        }
    }
    
    private boolean checkYN() {
        while (true) {
            String result = checkInputString("");
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }
    
    public Student createStudent(String name, String classes, double maths, double chemistry, double physics) {
        double average = 0;
        char type = 0 ;
        return new Student(name, classes, maths, physics, chemistry, average, type);
    }
    
    private void createStudent(List<Student> students) {
        while (true) {
            
            String name = checkInputString("Name: ");
            
            String className = checkInputString("Classes: ");
            
            double math = checkInputMark("Maths");
            
            double chemistry = checkInputMark("Chemistry");
            
            double physics = checkInputMark("Physics");
            double average = (math + chemistry + physics) / 3;
            students.add(createStudent(name, className, math, chemistry, physics));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!checkYN()) {
                return;
            }
        }
    }
    
    public List<Student> averageStudent(List<Student> students) {
        List<Student> classified = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            double average = (students.get(i).getMath() + students.get(i).getChemistry() + students.get(i).getPhysical()) / 3;
            students.get(i).setAverage(average);
            char type = 0;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else if(average < 4){
                type = 'D';
            }
            students.get(i).setType(type);
            classified.add(new Student(students.get(i).getStudentName(), students.get(i).getClassName(), students.get(i).getMath(), students.get(i).getPhysical(), students.get(i).getChemistry(), average, type));
        }
        
        return classified;
        
    }
    
    private void displayInformationStudent(List<Student> ls, HashMap<String, Double> getPercentTypeStudent) {
        int i = 0;
        for (Student mem : ls) {
            System.out.println("------ Student" + (++i) + " info ------");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
        System.out.println("--------Classification Info -----");
        getPercentTypeStudent.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " :" + entry.getValue() + "%");
        });
    }
    
    public int countType(List<Student> students, char c) {
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getType() == c ) {
                count++;
            }
        }
        return count;
    }
    
    public HashMap<String, Double> getPercentTypeStudent(List<Student> students){
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        int count=0;
        for(int i=65; i<69; i++){
            count = countType(students,(char)i);
            getPercentTypeStudent.put((char)i +"",((double)count/(double)students.size())*100);
        }
        return getPercentTypeStudent;
    }
//    private HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
//        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
//        int totalStudent = students.size();
//        double typeA = 0;
//        double typeB = 0;
//        double typeC = 0;
//        double typeD = 0;
//        for (int i = 0; i < totalStudent; i++) {
//            if (students.get(i).getType().equals("A")) {
//                typeA++;
//            }
//            if (students.get(i).getType().equals("B")) {
//                typeB++;
//            }
//            if (students.get(i).getType().equals("C")) {
//                typeC++;
//            }
//            if (students.get(i).getType().equals("D")) {
//                typeD++;
//            }
//        }
//        getPercentTypeStudent.put("A", typeA / totalStudent * 100);
//        // System.out.println(typeA / totalStudent * 100);
//        getPercentTypeStudent.put("B", typeB / totalStudent * 100);
//        //  System.out.println(typeB / totalStudent * 100);
//        getPercentTypeStudent.put("C", typeC / totalStudent * 100);
//        // System.out.println(typeC / totalStudent * 100);
//        getPercentTypeStudent.put("D", typeD / totalStudent * 100);
//        //  System.out.println(typeD / totalStudent * 100);
//        return getPercentTypeStudent;
//    }
    
    public static void main(String[] args) {
        Lab65 l = new Lab65();
        List<Student> students = new ArrayList<>();
        List<Student> classified;
        l.createStudent(students);
        classified = l.averageStudent(students);
        HashMap<String, Double> getPercentTypeStudent = l.getPercentTypeStudent(classified);
        l.displayInformationStudent(classified, getPercentTypeStudent);
    }
    
}
