/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import gui.CourseManagement;
import gui.SearchCourse;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class SearchCourseController {
    CourseManagement cm = new CourseManagement();
    SearchCourse sc = new SearchCourse(cm, true);
    JButton btnSearch = sc.getBtnSearch();
    JTextField txtSCode = sc.getTxtSCode();
    JTextField txtSName = sc.getTxtSName();
    JTextField txtSCredit = sc.getTxtSCredit();
    public SearchCourseController(ArrayList<Course> list){
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //if code course is empty, return message dialog
                if (txtSCode.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Must input code course to search");
                }else{
                boolean isFound = false;
                //search each course in list
                for (Course c : list) {
                    //if course need to search is equal code course in arraylist,
                    //show all information
                    if (c.getCode().equalsIgnoreCase(txtSCode.getText())) {
                        txtSName.setText(c.getName());
                        txtSCredit.setText(c.getCredit());
                        isFound=true;
                    }
                }
                //if can't found any course code equal, return not found
                if (!isFound) {
                    txtSName.setText("");
                    txtSCredit.setText("");
                    JOptionPane.showMessageDialog(null, "Can't found courses");
                }
            }
            }
        });
        sc.setVisible(true);
    }
}
