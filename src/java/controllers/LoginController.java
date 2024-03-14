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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDAO;
import users.UserDTO;
import users.LoginError;

import utils.AppContants;
import utils.SHA256;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final String SEARCH_PAGE = "index.jsp";
    private final String LOGIN_FAIL = "invalid.html";
    private final String USER_PAGE = "user.jsp";
    private final String DASHBOARD_PAGE = "dashboard.jsp";
    private final String STAFF_PAGE = "listInquiryStaff.jsp";

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
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        String url = siteMaps.getProperty(AppContants.LoginFeatures.LOGIN_PAGE);
        LoginError errors = new LoginError();
        boolean foundErr = false;
        try {
            UserDAO dao = new UserDAO();

            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("txtemail");
            String password = request.getParameter("txtpassword");
            byte[] getSha = SHA256.getSHA(password);
            String passSHA = SHA256.toHexString(getSha);
            boolean checkAccIsActive = dao.checkAccountIsActive(email, passSHA);
            if (checkAccIsActive == false) {
                foundErr = true;
                errors.setAccIsactive("Account not active!");
            }
            if (foundErr) {
                request.setAttribute("LOGIN_ERR", errors);
            } else {
                UserDTO user = dao.checkLogin(email, passSHA);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", user);
                    session.setAttribute("LOGIN_USER", user);
                    String role = user.getRoleId();
                    if ("1".equals(role)) {
                        url = siteMaps.getProperty(AppContants.UpdateUserProfile.SEARCH_PAGE);
                    } else if ("2".equals(role)) {
                        url = siteMaps.getProperty(AppContants.UpdateUserProfile.STAFF_PAGE);
                    } else if ("3".equals(role)) {
                        url = siteMaps.getProperty(AppContants.UpdateUserProfile.DASHBOARD_PAGE);
                    }
                } else {
                    errors.setAccountNotFound("Wrong email and password! Try again");
                    request.setAttribute("LOGIN_ERR", errors);
                }

            //    Cookie cookie = new Cookie(email, password);
                //    cookie.setMaxAge(120 * 1);
                //    response.addCookie(cookie);
            }
        } catch (SQLException ex) {
            log("LoginController _ SQL " + ex.getMessage());

        } finally {
//            response.sendRedirect(url);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
