/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.UserDAO;
import users.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SigUpController", urlPatterns = {"/SigUpController"})
public class SigUpController extends HttpServlet {

   private final String LOGIN_USER = "login.jsp";
    private final String ERROR_PAGE = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
           String email = request.getParameter("email");
        String password = request.getParameter("su-password");
        String rePassword = request.getParameter("re-su-password");
        Random generator = new Random();
        String randomId = "u" + String.valueOf(generator.nextInt(999999));

        if (!password.equals(rePassword)) {
            request.setAttribute("result", "Passwords do not match!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            UserDAO uf = new UserDAO();

            UserDTO u = uf.checkAccountExist(email);
            if (u == null) {
                u = new UserDTO();
                u.setUserId(randomId);
                u.setEmail(email);
                u.setPassword(password);
                request.setAttribute("user", u);

                if (uf.signUp(u)) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                } else {
                    request.setAttribute("result", "Can't insert this account.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("result", "Email already exists!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }

    
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error retrieving projects: " + e.getMessage());
            RequestDispatcher errorDispatcher = request.getRequestDispatcher(ERROR_PAGE);
            errorDispatcher.forward(request, response);
            return;
        }
        RequestDispatcher rd = request.getRequestDispatcher(LOGIN_USER);
        rd.forward(request, response);
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
