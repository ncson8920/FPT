/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;


/**
 *
 * @author Admin
 */
public class News {
    private int id;
    private String title;
    private String description;
    private String summary;
    private String image;
    private String author;
    private Date datePost;
    private Time timePost;

    public News() {
    }

    public News(int id, String title, String description, String summary, String image, String author, Date datePost, Time timePost) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.image = image;
        this.author = author;
        this.datePost = datePost;
        this.timePost = timePost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public Time getTimePost() {
        return timePost;
    }

    public void setTimePost(Time timePost) {
        this.timePost = timePost;
    }

    

    
    
}
