/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import inquiry.ConstructionDAO;
import inquiry.Construction;
import inquiry.PriceRange;
import inquiry.PriceRangeDAO;
import inquiry.ProjectType;
import inquiry.ProjectTypeDAO;
import inquiry.Scale;
import inquiry.ScaleDAO;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Admin
 */
@WebServlet(name = "adminListConstruction", urlPatterns = {"/adminListConstruction"})
public class adminListConstruction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String ERROR_PAGE = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            ConstructionDAO constructionDAO = new ConstructionDAO();
            List<Construction> constructions = constructionDAO.selectConstructionList();
            request.setAttribute("listConstruction", constructions);

            ScaleDAO scaleDAO = new ScaleDAO();
            List<Scale> scaleList = scaleDAO.selectScaleList();
            request.setAttribute("scaleList", scaleList);

            PriceRangeDAO priceRangeDAO = new PriceRangeDAO();
            List<PriceRange> priceList = priceRangeDAO.selectPriceRangeList();
            request.setAttribute("priceList", priceList);

            ProjectTypeDAO projectTypeDAO = new ProjectTypeDAO();
            List<ProjectType> projectTypeList = projectTypeDAO.selectProjectTypeList();
            request.setAttribute("projectTypeList", projectTypeList);

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error retrieving projects: " + e.getMessage());
            RequestDispatcher errorDispatcher = request.getRequestDispatcher(ERROR_PAGE);
            errorDispatcher.forward(request, response);
            return;
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
