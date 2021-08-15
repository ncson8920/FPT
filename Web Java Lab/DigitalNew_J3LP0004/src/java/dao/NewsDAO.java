/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.News;

/**
 *
 * @author Admin
 */
public class NewsDAO {
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    // function to get top 1 news from database
    public News getNews() {
        String query = "select top 1 * from news\n"
                + "order by timePost desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            // loop to get news
            while (rs.next()) {
                return new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getTime(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    // function to get news by id from database
    public News getNewsByID(int id) {
        String query = "select * from news\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            // loop to get news by id
            while (rs.next()) {
                return new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getTime(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    //function to get list of news from database
    public List<News> getListNews(int number, int select) {
        List<News> list = new ArrayList<>();
        String query = "select top "+number+" * from news\n"
                + "where id !=(\n"
                + "select top 1 id from news\n"
                + "where id = ?\n"
                + "order by timePost desc)\n"
                + "order by timePost desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, select);
            rs = ps.executeQuery();
            // loop to get list news
            while (rs.next()) {
                list.add(new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getTime(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    // function to get list news have tittle like txt
    public List<News> searchNews(String txt) {
        List<News> list = new ArrayList<>();
        String query = "select * from news \n"
                + "where title like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            // loop to get list news
            while (rs.next()) {
                list.add(new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getTime(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
