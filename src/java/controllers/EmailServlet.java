/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import email.Email_DTO;
import email.SendEmail;
import email.VerifyEmailErr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
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
@WebServlet(name = "EmailServlet", urlPatterns = {"/EmailServlet"})
public class EmailServlet extends HttpServlet {

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
        String email = request.getParameter("txtEmail");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(AppContants.EmailFeatures.VERIFY_EMAIL_PAGE);
        VerifyEmailErr errors = new VerifyEmailErr();
        UserDAO accDAO=new UserDAO();
        boolean foundErr = false;
        try {
            /* TODO output your page here. You may use following sample code. */
            boolean checkEmailExit = accDAO.checkEmail(email);
            if (checkEmailExit == false) {
                foundErr = true;
                errors.setEmailNotExisted("Email does not exist try again!");
            }
             boolean checkEmailActive= accDAO.checkEmailIsActive(email);
            if (checkEmailActive == true) {
                foundErr = true;
                errors.setEmailIsActive("This email already activated!");
            }
            if (foundErr) {
                request.setAttribute("VerifyMail_ERR", errors);
            }else{
                SendEmail sm = new SendEmail();
                String code = sm.getRandom();
                Email_DTO user = new Email_DTO( email, code);
                boolean test = sm.sendEmail(user);
                if (test==true) {
                    HttpSession session = request.getSession();
                    session.setAttribute("authcode", user);
                    url = siteMaps.getProperty(AppContants.EmailFeatures.VERIFY_CODE_PAGE);
                    request.setAttribute("VerifyEmail_done","done");
                    session.setAttribute("email_A",user);
                } else {
                    errors.setCannotSend("Can not send mail. Try again");
                    request.setAttribute("VerifyMail_ERR", errors);
                    
                }
            }
            
        }catch (SQLException ex) {
            log("EmailServlet _ SQL " + ex.getMessage());
        } finally {
            // goi sendRedirect de btAction ko bi goi lai -> ko bi trung lai
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
