/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.Frame;
import gui.Update;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class UpdateController {

    Frame f = new Frame();
    Update u = new Update(f, true);
    JTextField tfName = u.getTfName();
    JRadioButton rbMale = u.getRbMale();
    JRadioButton rbFemale = u.getRbFemale();
    ButtonGroup bg = new ButtonGroup();
    JComboBox<String> cbbRole = u.getCbbRole();
    JLabel lbImage = u.getLbImage();
    JButton btUpdate = u.getBtUpdate();

    Connection cnt;
    Statement stm;
    ResultSet rs;

    String linkImage;

    private void connect() {
        try {
            cnt = (new context.DBContext()).getConnection();
            System.out.println("Connect successfully");
            stm = cnt.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("connect ERROR: " + e.getMessage());
        }
    }

    public UpdateController(int id, String oldName, int oldGender, String oldRole, String oldLinkImage) {
        connect();
        
        bg.add(rbMale);
        bg.add(rbFemale);
        tfName.setText(oldName);
        if (oldGender == 0) {
            rbFemale.setSelected(true);
        } else if (oldGender == 1) {
            rbMale.setSelected(true);
        }
        if (oldRole.equalsIgnoreCase("admin")) {
            cbbRole.setSelectedIndex(0);
        } else if (oldRole.equalsIgnoreCase("worker")) {
            cbbRole.setSelectedIndex(1);
        } else if (oldRole.equalsIgnoreCase("manager")) {
            cbbRole.setSelectedIndex(2);
        }
        ImageIcon icon = new ImageIcon(oldLinkImage);
        Image im = icon.getImage().getScaledInstance(lbImage.getWidth(),
                lbImage.getHeight(), java.awt.Image.SCALE_SMOOTH);
        lbImage.setIcon(new ImageIcon(im));
        linkImage = oldLinkImage;
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tfName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " please enter name");
                }else{
                    int gender = 0;
                if (rbMale.isSelected()) {
                    gender = 1;
                }
                String role = "";
                switch (cbbRole.getSelectedIndex()) {
                    case 0:
                        role = "Admin";
                        break;
                    case 1:
                        role = "Worker";
                        break;
                    case 2:
                        role = "Manager";
                        break;
                    default:
                        break;
                }
                String name = tfName.getText().trim();
                try {
                    stm = cnt.createStatement();
                    String strInsert = "update Info set name = '" + name + "',gender = '" + gender + "',role = '" + role + "',linkImage = '" + linkImage + "'where id = '" + id + "'";
                    stm.execute(strInsert);
                    JOptionPane.showMessageDialog(null, "Update successful");
                } catch (Exception e) {
                    System.out.println("update ERORR" + e.getMessage());
                }
                }
            }
        });
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFileChooser fc = new JFileChooser();
                int option = fc.showOpenDialog(u);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    linkImage = file.getPath();
                    if (!linkImage.endsWith(".jpg") && !linkImage.endsWith(".png")) {
                        JOptionPane.showMessageDialog(null, "please enter image file");
                        linkImage = "";
                        return;
                    }
                    ImageIcon icon = new ImageIcon(linkImage);
                    Image image = icon.getImage().getScaledInstance(lbImage.getWidth(),
                            lbImage.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    lbImage.setIcon(new ImageIcon(image));
                }
            }
        });
        u.setVisible(true);
    }
}
