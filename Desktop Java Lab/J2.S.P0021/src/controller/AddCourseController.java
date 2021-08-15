/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import javax.swing.JButton;
import javax.swing.JTextField;
import gui.AddCourse;
import gui.CourseManagement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class AddCourseController {
    CourseManagement cm = new CourseManagement();
    AddCourse ac = new AddCourse(cm, true);
    JButton btnAdd = ac.getBtnAdd();
    JButton btnClear = ac.getBtnClear();
    JTextField txtCode = ac.getTxtACode();
    JTextField txtName = ac.getTxtAName();
    JTextField txtCredit = ac.getTxtACredit();

    public AddCourseController(ArrayList<Course> list) {
        
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //if all text are empty, return message dialog
                if (txtCode.getText().isEmpty() && txtName.getText().isEmpty() && txtCredit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Course do not have enought information");
                }//if name course is empty, return message dialog
                else if (txtName.getText().isEmpty() && !txtCode.getText().isEmpty() && !txtCredit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter name course!");
                }//if code course is empty, return message dialog
                else if(txtCode.getText().isEmpty() && !txtName.getText().isEmpty() && !txtCredit.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter code course!");
                }//if credit course is empty, return message dialog
                else if(txtCredit.getText().isEmpty() && !txtName.getText().isEmpty() && !txtCode.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter credit course!");
                }//if code and credit course are empty, return message dialog
                else if(txtCredit.getText().isEmpty() && !txtName.getText().isEmpty() && txtCode.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter credit and code course!");
                }//if name and credit course are empty, return message dialog
                else if(txtCredit.getText().isEmpty() && txtName.getText().isEmpty() && !txtCode.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter credit and name course!");
                }//if code and name course are empty, return message dialog
                else if(!txtCredit.getText().isEmpty() && txtName.getText().isEmpty() && txtCode.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter code and name course!");
                }else {
                    String name = txtName.getText().trim().toLowerCase();
                    //replace all space by 1 space
                    name = name.replaceAll("\\s+", " ");
                    String[] a= name.split(" ");
                    String newName="";
                    for (String string : a) {
                        String toLowerCase = string.toLowerCase();
                        String replace = toLowerCase.replace(String.valueOf(toLowerCase.charAt(0)), String.valueOf(toLowerCase.charAt(0)).toUpperCase());
                        
                        newName+= replace+ " ";
                    }
                    StringBuilder sb = new StringBuilder(name);
                    //Matches all special characters except characters in the English alphabet, 
                    //number and space
                    String regex = "[^\\s\\w]*";
                    //uppercase first character of name
                    sb.replace(0, 1, String.valueOf(sb.charAt(0)).toUpperCase());
                    //search from head to the end of string
                    for (int i = 0; i < sb.length() - 1; i++) {
                        //if the index character is a space or special character,
                        //uppercase the next character
                        if (sb.charAt(i) == 32 || String.valueOf(sb.charAt(i)).matches(regex)) {
                            sb.replace(i + 1, i + 2, String.valueOf(sb.charAt(i + 1)).toUpperCase());
                        }
                    }
                    name = sb.toString();
                    Course c2 = new Course(txtCode.getText().trim().toUpperCase(), newName, txtCredit.getText().trim());
                    //If course need to add satisfy check to add condition, add to list
                    if (checktoAdd(list,c2)) {
                        list.add(c2);
                        JOptionPane.showMessageDialog(null, "Add Course successfully!!!");
                    }
                }
            }
        });

        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCode.setText("");
                txtName.setText("");
                txtCredit.setText("");
            }
        });
        ac.setVisible(true);
    }
    public boolean checktoAdd(ArrayList<Course> list, Course c) {
        //search all list course
        for (Course c1 : list) {
            //if name course need to add is equal any course in arraylist, return false
            if (c1.getCode().equalsIgnoreCase(c.getCode())) {
                JOptionPane.showMessageDialog(null, "This Course is existed");
                return false;
            }
        }
        //if credit is not a positive number, throw catch exception
        try {
            int a = Integer.parseInt(c.getCredit());
            //if credit > 33 or < 0, return false 
            if (a > 33 || a < 0) {
                JOptionPane.showMessageDialog(null, "Credit must be in range 0 - 33");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Credit must be a positive numver");
            return false;
        }
        return true;
    }
}
