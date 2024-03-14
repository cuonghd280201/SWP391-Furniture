/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projects.Project;
import projects.ProjectFacade;
import users.UserDTO;
import utils.AppContants;
import comments.CommentDAO;
import comments.CommentDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DisplayDetailProject", urlPatterns = {"/DisplayDetailProject"})
public class DisplayDetailProject extends HttpServlet {

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
        String url = siteMaps.getProperty(AppContants.DisplayDetailProject.MY_DETAIL_PROJECT_PAGE);
        try {
            // get userID from Session scope
            HttpSession session = request.getSession();
            int userId = ((UserDTO) session.getAttribute("USER")).getUserId();
            int projectID = Integer.parseInt(request.getParameter("projectID"));

            // call DAO
            ProjectFacade projectFacade = new ProjectFacade();
            Project projectDTO = projectFacade.getProjectById(projectID);
            request.setAttribute("DETAIL_PROJECT", projectDTO);

            CommentDAO commentDao = new CommentDAO();
            List<CommentDTO> commentsList = commentDao.getCommentByRecipeId(projectID);
            request.setAttribute("COMMENTS_LIST", commentsList);
        } catch (SQLException ex) {
            log("DisplayOwnRecipes Controller _ SQL " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
