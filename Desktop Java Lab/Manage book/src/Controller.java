
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Controller {

    Frame fr = new Frame();
    JButton btSave = fr.getBtSave();
    JButton btRemove = fr.getBtRemove();
    JButton btExit = fr.getBtExit();
    JList<String> listBook = fr.getListBook();
    JTextField tfCode = fr.getTfCode();
    JTextField tfName = fr.getTfName();
    JTextField tfAuthor = fr.getTfAuthor();
    JTextField tfPublisher = fr.getTfPublisher();
    JComboBox<String> cbbYear = fr.getCbbYear();
    JCheckBox cbForrent = fr.getCbForRent();
    

    public Controller() {
        
        ArrayList<Book> list = new ArrayList<>();
        fr.setVisible(true);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                String code = tfCode.getText().trim();
//                if (code.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Please enter book code");
//                }
//                // đề bài phần function detail nó có update book nhưng t đọc ở UI thì lại không có
//                //nên t nghĩ phần update nó trong button Save luôn
//                // nếu thầy bảo save là tạo 1 cái book mới thì dùng check exist
//                //còn button Save vừa là tạo vừa là update thì bỏ check exist đi dùng cái update ở dưới
//                // đây là phần check code exist
//                for (int i = 0; i < list.size(); i++) {
//                    if (code.equalsIgnoreCase(list.get(i).getCode())) {
//                        JOptionPane.showMessageDialog(null, "This book is exist");
//                    }
//                }
                String name = tfName.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter book name");
                }
                String author = tfAuthor.getText().trim();
                if (author.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter author");
                }
                String publisher = tfPublisher.getText().trim();
                if (publisher.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter publisher");
                }
                String year = (String) cbbYear.getSelectedItem();
                boolean forrent = false;
                if (cbForrent.isSelected()) {
                    forrent = true;
                }
//                // đây là phần update
                for (int i = 0; i < list.size(); i++) {
                    if (code.equalsIgnoreCase(list.get(i).getCode())) {
                        list.get(i).setName(name);
                        list.get(i).setAuthor(author);
                        list.get(i).setPublisher(publisher);
                        list.get(i).setYear(year);
                        list.get(i).setForrent(forrent);
                        getListBook(list);
                    JOptionPane.showMessageDialog(null, "Update successs");
                        return;
                    }
                }
                Book b = new Book(code, name, author, publisher, year, forrent);
                list.add(b);
                clear();
                getListBook(list);

                if (tfCode.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter book code");
                } else if (tfName.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter book name");
                } else if (tfAuthor.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter author");
                } else if (tfPublisher.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter publisher");
                } else {
                    String year = (String) cbbYear.getSelectedItem();
                    boolean forrent = false;
                    if (cbForrent.isSelected()) {
                        forrent = true;
                    }
                    Book b = new Book(tfCode.getText().trim(), tfName.getText().trim(), tfAuthor.getText().trim(), tfPublisher.getText().trim(), year, forrent);
                    list.add(b);
                    clear();
                    getListBook(list);
                }
            }

        });
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String code = tfCode.getText().trim();
                boolean check = false;
                for (int i = 0; i < list.size(); i++) {
                    if (code.equalsIgnoreCase(list.get(i).getCode())) {
                        list.remove(i);
                        clear();
                        check = true;
                    }
                }
                if (!check) {
                    JOptionPane.showMessageDialog(null, "Book not exist to remove");
                }
                getListBook(list);
                if (list.isEmpty()) {
                    btRemove.setEnabled(false);
                }
            }
        });
        listBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listBook.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (btSave.hasFocus()) {
                    btRemove.setEnabled(false);
                    return;
                }
                btRemove.setEnabled(true);
                if (listBook.getSelectedValue() == null) {
                    listBook.setSelectedIndex(0);
                    return;
                }
                int selected = listBook.getSelectedIndex();
                tfCode.setText(list.get(selected).getCode());
                tfName.setText(list.get(selected).getName());
                tfAuthor.setText(list.get(selected).getAuthor());
                tfPublisher.setText(list.get(selected).getPublisher());
                cbbYear.setSelectedItem(list.get(selected).getYear());
                if (list.get(selected).isForrent()) {
                    cbForrent.setSelected(true);
                } else {
                    cbForrent.setSelected(false);
                }
            }
        });
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        tfCode.setForeground(Color.red);
    }

    private void getListBook(ArrayList<Book> list) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < list.size(); i++) {
            listModel.addElement(list.get(i).getName());
        }
        listBook.setModel(listModel);
    }

    private void clear() {
        tfCode.setText("");
        tfName.setText("");
        tfAuthor.setText("");
        tfPublisher.setText("");
        cbbYear.setSelectedIndex(0);
        cbForrent.setSelected(false);
    }
}
