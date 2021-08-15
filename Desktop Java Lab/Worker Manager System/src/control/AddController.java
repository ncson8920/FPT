/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Worker;
import gui.Add;
import gui.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
public class AddController {

    Frame f = new Frame();
    Add a = new Add(f, true);
    JTextField tfName = a.getTfName();
    JRadioButton rbMale = a.getRbMale();
    JRadioButton rbFemale = a.getRbFemale();
    ButtonGroup bg = new ButtonGroup();
    JComboBox<String> cbbRole = a.getCbbRole();
    JLabel lbImage = a.getLbImage();
    JButton btAdd = a.getBtAdd();

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

    public AddController(List<Worker> list) {
        linkImage="";
        connect();
        bg.add(rbMale);
        bg.add(rbFemale);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int id;
                if (list.isEmpty()) {
                    id = 1;
                } else {
                    id = list.get(list.size() - 1).getId() + 1;
                }
                if (tfName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " please enter name");
                }
                else if (!rbMale.isSelected() && !rbFemale.isSelected()) {
                    JOptionPane.showMessageDialog(null, " please choose gender");
                }
                else if (linkImage.isEmpty()) {
                    JOptionPane.showMessageDialog(null, " please choose image");
                }else {
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
                    String strInsert = "Insert into Info values('" + id + "','" + name + "','" + gender + "','" + role + "','" + linkImage + "')";
                    stm.execute(strInsert);
                    JOptionPane.showMessageDialog(null, "Add successful");
                } catch (HeadlessException | SQLException e) {
                    System.out.println("add ERROR: " + e.getMessage());
                }
                }
                
            }
        });
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFileChooser fc = new JFileChooser();
                int option = fc.showOpenDialog(a);
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
        a.setVisible(true);
    }
}
