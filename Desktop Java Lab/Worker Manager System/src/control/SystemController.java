/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Worker;
import gui.Add;
import gui.Detail;
import gui.Frame;
import gui.Update;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SystemController {

    Frame f = new Frame();
    Add a = new Add(f, true);
    Update u = new Update(f, true);
    Detail d = new Detail(f, true);
    JTable tbInfo = f.getTbInfo();
    JButton btAdd = f.getBtAdd();
    JButton btUpdate = f.getBtUpdate();
    JButton btDetail = f.getBtViewDetail();
    List<Worker> list = new ArrayList<>();

    public SystemController() {

        connect();
        loadData();
        tbInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddController ac = new AddController(list);
                loadData();
                btUpdate.setEnabled(false);
                btDetail.setEnabled(false);
            }
        });
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selected = tbInfo.getSelectedRow();
                int id = list.get(selected).getId();
                String name = list.get(selected).getName();
                int gender = list.get(selected).getGender();
                String oldLink = list.get(selected).getImage();
                String role = list.get(selected).getRole();
                UpdateController ac = new UpdateController(id, name, gender, role, oldLink);
                loadData();
                btUpdate.setEnabled(false);
                btDetail.setEnabled(false);
            }
        });
        btDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selected = tbInfo.getSelectedRow();
                String name = list.get(selected).getName();
                int gender = list.get(selected).getGender();
                String role = list.get(selected).getRole();
                String oldLink = list.get(selected).getImage();
                DetailController ac = new DetailController(name, gender, role, oldLink);
            }
        });
        tbInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdate.setEnabled(true);
                btDetail.setEnabled(true);
            }
        });
        f.setVisible(true);
    }
    ResultSet rs;
    Connection cnt;
    Statement stm;

    private void connect() {
        try {
            cnt = (new context.DBContext()).getConnection();
            System.out.println("Connect successfully");
            stm = cnt.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("connect ERROR: " + e.getMessage());
        }
    }
    DefaultTableModel dtm;

    private void loadData() {
        try {
            dtm = (DefaultTableModel) tbInfo.getModel();
            dtm.setRowCount(0);
            String strSelect = "select * from Info";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int gender = 1;
                String genderWorker = "Male";
                if (!rs.getBoolean(3)) {
                    gender = 0;
                    genderWorker = "Female";
                };
                String role = rs.getString(4);
                String linkImage = rs.getString(5);
                list.add(new Worker(id, name, gender, role, linkImage));
                dtm.insertRow(dtm.getRowCount(), new Object[]{name, genderWorker, linkImage});
            }
        } catch (SQLException e) {
            System.out.println("load ERROR: " + e.getMessage());
        }
    }
}
