/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.DisplayCourse;
import gui.SearchCourse;
import gui.CourseManagement;
import gui.AddCourse;
import entity.Course;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class CourseController {

    ArrayList<Course> list = new ArrayList<>();
    CourseManagement cm = new CourseManagement();
    AddCourse ac = new AddCourse(cm, true);
    SearchCourse sc = new SearchCourse(cm, true);
    DisplayCourse lc = new DisplayCourse(cm, true);
    JButton btnAC = cm.getBtnAC();
    JButton btnDC = cm.getBtnDC();
    JButton btnSC = cm.getBtnSC();
    JButton btnExit = cm.getBtnExit();

    public CourseController() {
        cm.setVisible(true);

        btnAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseController acc = new AddCourseController(list);
            }
        });

        btnSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCourseController scc = new SearchCourseController(list);
            }
        });

        btnDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayCourseController dc = new DisplayCourseController(list);
            }
        });

        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
    }
}
