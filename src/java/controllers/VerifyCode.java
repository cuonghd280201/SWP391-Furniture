/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import email.Email_DTO;
import email.VerifyCodeErr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDAO;
import utils.AppContants;

/**
 *
 * @author Admin
 */
@WebServlet(name = "VerifyCode", urlPatterns = {"/VerifyCode"})
public class VerifyCode extends HttpServlet {

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
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(AppContants.VerifyCodeFeatures.VERIFY_CODE_PAGE);
        HttpSession session = request.getSession();
        VerifyCodeErr errors = new VerifyCodeErr();
        try {
            Email_DTO user = (Email_DTO) session.getAttribute("authcode");
            String code = request.getParameter("authcode");
            //String email = request.getParameter("txtEmail");
            if (code.equals(user.getCode())) {
                UserDAO accDAO = new UserDAO();
                int userID = accDAO.checkUserIdWithEmail(user.getEmail());
                boolean check = accDAO.verifyEmail(userID);
                if (check == true) {
                    url = siteMaps.getProperty(AppContants.VerifyCodeFeatures.LOGIN_PAGE);
                    request.getSession().setAttribute("verifyCode_done", errors);
                }
            } 
            if(code!= user.getCode()){
                
                //url = siteMaps.getProperty(AppContants.VerifyCodeFeatures.VERIFY_CODE_PAGE);
                request.setAttribute("VerifyCode_ERR", "done");
                errors.setCodeIncorrect("This code you entered is incorrect!");
            }
        } catch (SQLException ex) {
            log("EmailServlet _ SQL " + ex.getMessage());
        } // goi sendRedirect de btAction ko bi goi lai -> ko bi trung lai
        finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response); // sendRedirect + urlRewriting ~
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(VerifyCode.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(VerifyCode.class.getName()).log(Level.SEVERE, null, ex);
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
