/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projectDetails.ProjectDetailsDAO;
import projectDetails.ProjectDetailsDTO;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "SearchProjectCController", urlPatterns = {"/SearchProjectCController"})
public class SearchProjectCController extends HttpServlet {

    private final String MAIN_PAGE = "project-list.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = MAIN_PAGE;
            try{
                String searchValue = request.getParameter("txtsearch");
                if(searchValue == null){
                    searchValue = "";
                }
                
//                ProjectTypeDAO dao = new ProjectTypeDAO();
//                List<ProjectTypeDTO> result = dao.listProjectType();
//                
//                ProjectDAO projectdao = new ProjectDAO();
//                List<ProjectDTO> listProject = projectdao.listProject(searchValue);
                
                ProjectDetailsDAO dao = new ProjectDetailsDAO();
                List<ProjectDetailsDTO> listProject = dao.searchListProjectDetailsByName(searchValue);
                
//                request.setAttribute("SEARCH_PROJECT_TYPE", result);
//                request.setAttribute("SEARCH_PROJECT", listProject);
                request.setAttribute("SEARCH_PROJECT", listProject);
                url = MAIN_PAGE;
            }catch(Exception e){
                
            }finally{
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
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
