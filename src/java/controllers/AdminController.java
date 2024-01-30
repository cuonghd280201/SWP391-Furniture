/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.User;
import users.UserFacade;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {

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
        String action = String.valueOf(request.getAttribute("action"));
        String controller = String.valueOf(request.getAttribute("controller"));

        switch (action) {
            case "dashboard":
                list(request, response);
                count(request, response);
                break;
            case "managerCustomer":
                list(request, response);
               // detailCustomer(request,response);
                break;
            case "managerStaff":
                listStaff(request, response);
                break;
                
            case "showDetail":
                detailCustomer(request,response);
                break;
            default:
                request.setAttribute("action", "index");
                request.setAttribute("controller", "error");
                request.setAttribute("message", "error");
        }

        request.getRequestDispatcher(config.Config.LAYOUT).forward(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFacade userFacade = new UserFacade();
        List<User> userList = userFacade.selectAllUsers();
        request.setAttribute("listUser", userList);
    }
      protected void detailCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id").trim();
        UserFacade bf = new UserFacade();
        User user = bf.detailUserById(id);
        request.setAttribute("userDetail", user);
    request.getRequestDispatcher("/WEB-INF/views/admin/managerCustomer.jsp").forward(request, response);
    }
    
     protected void listStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFacade userFacade = new UserFacade();
        List<User> userList = userFacade.selectAllStaffs();
        request.setAttribute("listStaff", userList);
    }

    protected void count(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFacade userFacade = new UserFacade();
        int numberOfUsers = userFacade.countAllUsers();
        request.setAttribute("numberOfUsers", numberOfUsers);

    }
    prot

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
