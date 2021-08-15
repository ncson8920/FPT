/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import gui.CourseManagement;
import gui.DisplayCourse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */

//Implement Comparator in a separate class
class sortbyCredit implements Comparator<Course> {
    //using comparator to Sort credit up ascending
    @Override
    public int compare(Course a, Course b) {
        //if credit course a is less than course b, return -1
        if (Integer.parseInt(a.getCredit()) < Integer.parseInt(b.getCredit())) {//2-3-4
            return -1;
        }//if credit course a is higher than course b, return 1
        if (Integer.parseInt(a.getCredit()) > Integer.parseInt(b.getCredit())) {
            return 1;
        } //if credit course a is equal course b, return 0
        else {
            return 0;
        }
    }
//    public void sortByCredit(List<Course> list){
//        Course temp= null;
//        for (int i = 0; i < list.size(); i++) {
//            if(Integer.parseInt(b.getCredit())list.get(i).getCredit())
//        }
//    }

}

public class DisplayCourseController {

    CourseManagement cm = new CourseManagement();
    DisplayCourse lc = new DisplayCourse(cm, true);
    JButton btnDC = cm.getBtnDC();
    JTextArea txtDisplay = lc.getTxtAllCourses();

    public DisplayCourseController(ArrayList<Course> list) {
        txtDisplay.setText("");
        list.sort(new sortbyCredit());
        //browse all course in list, display list course in txtDisplay
        for (Course c1 : list) {
            String a = c1.getCode() + " | " + c1.getName() + " | " + c1.getCredit() + "\n";
            txtDisplay.append(String.valueOf(a));
        }
        lc.setVisible(true);
    }

}
