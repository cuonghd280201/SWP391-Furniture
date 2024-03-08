/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import inquiry.InquiryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projects.ProjectFacade;
import users.UserDAO;
import users.UserDTO;
import utils.AppContants;

/**
 *
 * @author Admin
 */
@WebServlet(name = "adminDashboardController", urlPatterns = {"/adminDashboardController"})
public class adminDashboardController extends HttpServlet {

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
        String url = AppContants.Admin.ADMIN_DASHBOARD;
        ArrayList<Integer> result = null;
        HttpSession session = request.getSession();
        UserDAO userFacade = new UserDAO();
        int numberOfUsers = userFacade.countAllUsers();
        session.setAttribute("numberOfUsers", numberOfUsers);

        int numberOfCustomers = userFacade.countAllCustomers();
        session.setAttribute("numberOfCustomers", numberOfCustomers);

        int numberOfStaffs = userFacade.countAllStaffs();
        session.setAttribute("numberOfStaffs", numberOfStaffs);

        ProjectFacade projectFacade = new ProjectFacade();
        int numberOfProjects = projectFacade.countAllProjects();
        session.setAttribute("numberOfProjects", numberOfProjects);
        InquiryDAO inquiryDAO = new InquiryDAO();
        int numberOfInquirys = inquiryDAO.countAllInquirys();
        session.setAttribute("numberOfInquirys", numberOfInquirys);

        List<UserDTO> userList = userFacade.selectAllUsersAdmin();
        session.setAttribute("listUser", userList);
        response.sendRedirect(url);

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
