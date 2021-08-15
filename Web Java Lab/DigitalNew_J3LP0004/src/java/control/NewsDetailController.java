/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.NewsDAO;
import entity.News;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class NewsDetailController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get id news from jsp
            String newsId = request.getParameter("newsId");
            int id = Integer.parseInt(newsId);
            // get data from DAO
            NewsDAO dao = new NewsDAO();
            News news = dao.getNewsByID(id);
            List<News> listNews = dao.getListNews(10,id);
            SimpleDateFormat sdfDate = new SimpleDateFormat("MMM dd yyyy");
            SimpleDateFormat sdfTime = new SimpleDateFormat("h:mm a");
            String date = sdfDate.format(news.getDatePost());
            String time = sdfTime.format(news.getTimePost());
            // set data to jsp
            request.setAttribute("date", date);
            request.setAttribute("time", time.toLowerCase());
            request.setAttribute("news", news);
            request.setAttribute("listNews", listNews);
            request.getRequestDispatcher("HomePage.jsp").
                    forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("Error", e);
            request.getRequestDispatcher("Error.jsp").
                    forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
