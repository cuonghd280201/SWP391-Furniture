/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;
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
import users.RegisterError;
import users.UserDAO;
import users.UserDTO;
import utils.AppContants;
import utils.SHA256;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SigUpController", urlPatterns = {"/SigUpController"})
public class SigUpController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(AppContants.RegisterFeatures.ERROR_PAGE);
        RegisterError errors = new RegisterError();
        boolean foundErr = false;
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String confirm = request.getParameter("txtConfirm");
        String phoneNumber = request.getParameter("txtPhonenumber");
        Date create_At = Date.valueOf(LocalDate.now());
        //String register = request.getParameter("btAction");
        /*
         Must be 8-15 characters and must start with a letter
         May not contain special characters – only letters and numbers
         */
        Pattern passwordPattern = Pattern.compile("[a-zA-Z0-9]{8,}$");
        //Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        /*
         Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
         */
        //Pattern fullnamePattern = Pattern.compile("^([a-zA-Z0-9]+|[a-zA-Z0-9]+\\s{1}[a-zA-Z0-9]{1,}|[a-zA-Z0-9]+\\s{1}[a-zA-Z0-9]{3,}\\s{1}[a-zA-Z0-9]{1,})$");
        Pattern emailPattern = Pattern.compile(
                "^[a-zA-Z][\\w-.]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
//        String EMAIL_PATTERN
//                = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        /*  - Bắt đầu bằng chữ cái.
         - Chỉ chứa chữ cái, chữ số và dấu gạch ngang (-).
         - Chứa một ký tự @, sau @ là tên miền.
         - Tên miền có thể là domain.xxx.yyy hoặc domain.xxx. 
         Trong đó xxx và yyy là các chữ cái và có độ dài từ 2 trở lên.*/
        Pattern phonenumberPattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
        /*
         0388888888
         0588888888
         0788888888
         0888888888
         0988888888
         8488888888
         */
        try {
            UserDAO accDAO = new UserDAO();
            if (passwordPattern.matcher(password).matches() == false) {
                foundErr = true;
                errors.setPasswordFormatErr("Password wrong format.\n  "
                        + "Minimum eight characters\n"
                        + "May not contain special character");
            }
            if (!confirm.trim().equals(password)) {
                foundErr = true;
                errors.setConfirmNotMathched("Confirm must matches password");
            }
//            if (fullnamePattern.matcher(fullname).matches() == false) {
//                foundErr = true;
//                errors.setFullnameFormatErr("Fullname wrong format");
//            }

            boolean checkEmailExit = accDAO.checkEmail(email);
            if (emailPattern.matcher(email).matches() == false) {
                foundErr = true;
                errors.setEmailFormatErr("Email Start with a letter.\n"
                        + "              - Contains only letters, numbers and dashes (-), doc (.)\n"
                        + "              - Contains an @ character, after @ is the domain name.");
            }
            if (checkEmailExit == true) {
                foundErr = true;
                errors.setEmailExisted("Email existed try again!");
            }

            boolean checkPhonenumberExit = accDAO.checkPhonenumber(phoneNumber);
            if (phonenumberPattern.matcher(phoneNumber).matches() == false) {
                foundErr = true;
                errors.setPhonenumberFormatErr("Phonenumer must is Vietnam's phone number!");
            }
            if (checkPhonenumberExit == true) {
                foundErr = true;
                errors.setPhonenumberExisted("Phonenumber existed try again!");
            }

            if (foundErr) {
                request.setAttribute("REGISTER_ERR", errors);
            } else {
                //make user object
                byte[] getSha = SHA256.getSHA(password);
                String passSHA = SHA256.toHexString(getSha);
                UserDTO userDto = new UserDTO();
                UserDTO accDto = new UserDTO(firstName, lastName, passSHA, email, phoneNumber, create_At, true);
                //create a database model
                UserDAO userDao = new UserDAO();
                int cuurentUserId = userDao.getCurrentUserId();
                boolean userResult = userDao.saveUser(accDto);
                if (userResult) {
                    url = siteMaps.getProperty(AppContants.RegisterFeatures.VERIFY_EMAIL_PAGE);
                    HttpSession session = request.getSession(true);
                    session.setAttribute(firstName, firstName);

                    String message = "Your account has been successfully created, please login to use the website";
                    request.getSession().setAttribute("Register_done", message);
                } else {
                    errors.setFirstnameFormatErr("Sign Up Fail!");
                    request.setAttribute("REGISTER_ERR", errors);
                }
            }

        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateAccountController _ SQL " + msg);
            if (msg.contains("duplicate")) { // trung username (key) cung la SQLException
                errors.setFirstnameFormatErr(firstName + " is existed");
                request.setAttribute("REGISTER_ERR", errors);
            }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SigUpController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SigUpController.class.getName()).log(Level.SEVERE, null, ex);
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
