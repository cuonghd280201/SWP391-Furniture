/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDAO;
import users.UserDTO;
import utils.AppContants;

import comments.CommentDAO;
/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateNewCommentController", urlPatterns = {"/CreateNewCommentController"})
public class CreateNewCommentController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        // End get site map

        // Mapping url        
        String urlRewriting = siteMaps.getProperty(AppContants.AddNewCommentFeature.ERROR_PAGE);
        //user_id       int(11)
        //recipe_id     int(11)
        //comment_detail text
        //created_date
        //last_modified
        //is_actived
        try {
            HttpSession session = request.getSession(true);
            UserDTO currentUser = (UserDTO) session.getAttribute("USER");
            if (currentUser == null) {
                urlRewriting = siteMaps.getProperty(AppContants.AddNewCommentFeature.LOGIN_PAGE);
            } else {
                int userID = currentUser.getUserId();
                int projectID = Integer.parseInt(request.getParameter("txtProjectID"));
                String commentDetail = request.getParameter("txtCommentDetail");
                Date createAt = new Date(Calendar.getInstance().getTime().getTime());
                Date updateAt = new Date(Calendar.getInstance().getTime().getTime());
                boolean is_actived = true;
//            System.out.println("UnitTest: " + user_id + recipe_id + comment_detail + created_date + last_modified + is_actived);
                CommentDAO dao = new CommentDAO();
                if (dao.addNewComment(userID, projectID, commentDetail, createAt, updateAt, is_actived)) {
                    urlRewriting = siteMaps.getProperty(AppContants.AddNewCommentFeature.DISPLAY_SINGLE_RECIPE_CONTROLLER) + "?" + "projectID=" + projectID;

                }//end check result
            }//end check has been login
        } catch (SQLException ex) {
            log("CreateNewComment Controller _ SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(urlRewriting);
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
