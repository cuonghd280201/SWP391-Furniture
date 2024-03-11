/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import inquiry.Inquiry;
import inquiry.InquiryDAO;
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
@WebServlet(name = "SaveDraftInquiryController", urlPatterns = {"/SaveDraftInquiryController"})
public class SaveDraftInquiryController extends HttpServlet {

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
            String inquiryTittle = request.getParameter("txtInquiryTittle");
            int constructionID;
            int scaleID;
            int projectTypeID;
            int priceRangeID;
            String constructionIDString = request.getParameter("txtConstructionID");
            if (constructionIDString != null && !constructionIDString.isEmpty()) {
                constructionID = Integer.parseInt(constructionIDString);
            } else {
                constructionID = 1; // or any default value that represents null
            }

            // Parse scaleID
            String scaleIDString = request.getParameter("txtScaleID");
            if (scaleIDString != null && !scaleIDString.isEmpty()) {
                scaleID = Integer.parseInt(scaleIDString);
            } else {
                scaleID = 1; // or any default value that represents null
            }

            // Parse projectTypeID
            String projectTypeIDString = request.getParameter("txtProjectTypeID");
            if (projectTypeIDString != null && !projectTypeIDString.isEmpty()) {
                projectTypeID = Integer.parseInt(projectTypeIDString);
            } else {
                projectTypeID = 1; // or any default value that represents null
            }

            // Parse priceRangeID
            String priceRangeIDString = request.getParameter("txtPriceRangeID");
            if (priceRangeIDString != null && !priceRangeIDString.isEmpty()) {
                priceRangeID = Integer.parseInt(priceRangeIDString);
            } else {
                priceRangeID = 1; // or any default value that represents null
            }

            String description = request.getParameter("txtDescription");

            if (inquiryTittle == null || inquiryTittle.trim().isEmpty()) {
                // Handle case when inquiryTitle is not provided
                InquiryErrorDTO error = new InquiryErrorDTO();
                error.setInquiryTitleRequired("Inquiry title is required.");
                // Set error in request or session for displaying on JSP
                request.setAttribute("error", error);
                url = siteMaps.getProperty(AppContants.CreateInquiryFeature.ERROR_PAGE);
                request.getRequestDispatcher(url).forward(request, response);
                return;
            }

            Inquiry inquiry = new Inquiry(userID, inquiryTittle, constructionID, scaleID, projectTypeID, priceRangeID, description);
            InquiryDAO inquiryDAO = new InquiryDAO();
            boolean resultInsertInquiry = inquiryDAO.saveDraftInquiry(inquiry);
            if (resultInsertInquiry) {
                request.getSession().setAttribute("SAVE_NOTI", "success"); // Set success attribute
                url = siteMaps.getProperty(AppContants.DisplayInquiryFeartures.DISPLAY_INQUIRY_CUS_CONTROLLER);
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
