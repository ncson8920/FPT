/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.Detail;
import gui.Frame;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class DetailController {
    Frame f = new Frame();
    Detail d = new Detail(f, true);
    JTextField tfName = d.getTfName();
    JTextField tfGender = d.getTfGender();
            JTextField tfRole = d.getTfRole();
            JLabel lbImage = d.getLbImage();
            JButton btOK = d.getBtOK();
    public DetailController(String name, int gender, String role, String linkImage){
        
        tfName.setText(name);
        if (gender == 0) {
            tfGender.setText("Female");
        } else if (gender == 1) {
            tfGender.setText("Male");
        }
        tfRole.setText(role);
        ImageIcon icon = new ImageIcon(linkImage);
        Image im = icon.getImage().getScaledInstance(lbImage.getWidth(),
                lbImage.getHeight(), java.awt.Image.SCALE_SMOOTH);
        lbImage.setIcon(new ImageIcon(im));
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d.setVisible(false);
            }
        });
        d.setVisible(true);
    }
}
