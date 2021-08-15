/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.NewsDAO;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            // get text search from jsp
            String txt = request.getParameter("txtSearch");
            // get data from DAO
            NewsDAO dao = new NewsDAO();
            News news = dao.getNews();
            List<News> listNews = dao.getListNews(10, 1);
            List<News> listSearch = dao.searchNews(txt);
            int numberResults = 0;
            for (int i = 0; i < listSearch.size(); i++) {
                String title = listSearch.get(i).getTitle();
                String newTittle = "";
                int index = 0;
                for (int j = 0; j <= title.length() - txt.length(); j++) {
                    String sub = title.substring(j, txt.length() + j);
                    if (sub.equalsIgnoreCase(txt)) {
                        numberResults++;
                        newTittle += title.substring(index, j) + "<span class='highlight'>" + sub + "</span>";
                        index = txt.length() + j;
                    }
                }
                newTittle += title.substring(index, title.length());
                listSearch.get(i).setTitle(newTittle);
            }
            String result = "Keyword ' " + txt + " ' has " + listSearch.size() + " results found.";
            // set data to jsp
            request.setAttribute("news", news);
            request.setAttribute("listNews", listNews);
            request.setAttribute("listSearch", listSearch);
            request.setAttribute("result", result);
            request.setAttribute("sizeList", listSearch.size());
            request.setAttribute("txtSearch", txt);
            request.getRequestDispatcher("SearchPage.jsp").
                    forward(request, response);
        } catch (IOException | ServletException e) {
            request.setAttribute("Error", e);
            request.getRequestDispatcher("Error.jsp").
                    forward(request, response);
        }
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
