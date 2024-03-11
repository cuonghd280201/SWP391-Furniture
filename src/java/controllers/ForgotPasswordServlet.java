/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDAO;
import users.ForgotPasswordError;
import utils.AppContants;
import utils.SHA256;
/**
 *
 * @author Admin
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
         ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String urlRewriting = siteMaps.getProperty(AppContants.ForgotPaswordFeartures.FORGOT_PASSWORD_PAGE);
        UserDAO accDAO = new UserDAO();
        HttpSession session = request.getSession();
        ForgotPasswordError errors = new ForgotPasswordError();
        boolean foundErr = false;
        String email = request.getParameter("txtEmail");
        String phoneNumber = request.getParameter("txtPhonenumber");
        String confirm = request.getParameter("txtConfirm");
        String newPassword = request.getParameter("txtNewPassword");
        byte[] getShaNew= SHA256.getSHA(newPassword);
                String newPassSHA= SHA256.toHexString(getShaNew);
        Pattern passwordPattern = Pattern.compile("[a-zA-Z0-9]{8,}$");
        try {
            /* TODO output your page here. You may use following sample code. */
            boolean checkEmailExit = accDAO.checkEmail(email);
            if (checkEmailExit == false) {
                foundErr = true;
                errors.setEmailExisted("Email does not exist try again!");
            }
            boolean checkPhonenumberExit = accDAO.checkPhonenumber(phoneNumber);
            if (checkPhonenumberExit == false) {
                foundErr = true;
                errors.setPhonenumberExisted("Phonenumer does not existed try again!");
            }
            boolean checkEmailAndPhonenumber = accDAO.checkEmailAndPhonenumber(email, phoneNumber);
            if (checkEmailAndPhonenumber == false) {
                foundErr = true;
                errors.setEmailAndPhonenumberNotMathErr("Phone number and email must be from the same account! Please try again!");
            }
            boolean checkNewPassword= accDAO.checkPasswordEP(email, phoneNumber, newPassSHA);
            if (checkNewPassword==true) {
                foundErr = true;
                errors.setNewPasswordSameAsErr("The new password must not be the same as the old password");
            }
            if (passwordPattern.matcher(newPassword).matches() == false) {
                foundErr = true;
                errors.setNewPasswordFormatErr("Password wrong format.\n  "
                        + "Minimum eight characters\n"
                        + "May not contain special characte");
            } 
            if (!confirm.trim().equals(newPassword)) {
                foundErr = true;
                errors.setConfirmNotMathched("Confirm must matches new password");
            }if (foundErr) {
                request.setAttribute("FORGOTPASSWOD_ERR", errors);
            }else{
                boolean result= accDAO.uploadPasswordEP(email, phoneNumber, newPassSHA);
                if (result = true) {
                    urlRewriting = siteMaps.getProperty(AppContants.ForgotPaswordFeartures.LOGIN_PAGE);
                    session = request.getSession(true);
                    //session.setAttribute(olePassword, olePassword);
                    request.setAttribute("Forgot_done","done");
                } 
            }
            
        }catch (SQLException ex) {
            log("ForgotPasswordServlet _ SQL " + ex.getMessage());
        } finally {
            // goi sendRedirect de btAction ko bi goi lai -> ko bi trung lai
            RequestDispatcher rd = request.getRequestDispatcher(urlRewriting);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
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
