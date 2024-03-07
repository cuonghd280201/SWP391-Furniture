/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import inquiry.Construction;
import inquiry.ConstructionDAO;

import inquiry.InquiryErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDTO;
import utils.AppContants;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateConstructionController", urlPatterns = {"/CreateConstructionController"})
public class CreateConstructionController extends HttpServlet {

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
        String url = siteMaps.getProperty(AppContants.CreateInquiryFeature.ERROR_PAGE);
        //Get parameters
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("USER");

        if (user == null) {
            // Handle case when user is not logged in
            url = siteMaps.getProperty(AppContants.LoginFeatures.LOGIN_PAGE);
            response.sendRedirect(url);
            return;
        }
        try {
            int userID = user.getUserId();
            String constructionName = request.getParameter("txtConstructionName");
            String constructionDescription = request.getParameter("txtContructionDescription");
            Construction construction = new Construction(constructionName, constructionDescription);
            ConstructionDAO constructionDAO = new ConstructionDAO();
            boolean resultInsertInquiry = constructionDAO.insertContruction(construction);
            if (resultInsertInquiry) {
                url = siteMaps.getProperty(AppContants.Admin.LIST_CONTRUCTION_PAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateInquiryController.class.getName()).log(Level.SEVERE, null, ex);
            //            log("CreateNewRecipe Controller _ SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
