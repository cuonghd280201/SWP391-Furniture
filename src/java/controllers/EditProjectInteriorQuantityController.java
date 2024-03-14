/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interriorDetails.InteriorDetailsDAO;
import interriorDetails.InteriorDetailsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orderDetail.OrderDetailDAO;
import project2.ProjectDAO;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "EditProjectInteriorQuantityController", urlPatterns = {"/EditProjectInteriorQuantityController"})
public class EditProjectInteriorQuantityController extends HttpServlet {

    private final String PROJECT_DETAIL_PAGE = "detailProjectStaff.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = PROJECT_DETAIL_PAGE;
            String projectID_string = request.getParameter("projectID");
            String interiorID_string = request.getParameter("interiorID");
            String quantity_string = request.getParameter("interiorQuantity");
            String updateNoti = "";
            try{
                int projectID = Integer.parseInt(projectID_string);
                int interiorID = Integer.parseInt(interiorID_string);
                int interiorQuantity = Integer.parseInt(quantity_string);
                
                if(interiorQuantity < 1){
                    updateNoti = "Quantity must be equal or greater than 1";
                }else{
                    OrderDetailDAO OrderDao = new OrderDetailDAO();
                    LocalDateTime localDateTime = LocalDateTime.now();
                    Timestamp updateAt = Timestamp.valueOf(localDateTime);
                    int updateStatus = OrderDao.changeOrderDetailQuantity(projectID, interiorID, interiorQuantity);
                    ProjectDAO ProjectDao = new ProjectDAO();
                    int updateTime = ProjectDao.updateProjectUpdateAt(projectID, updateAt);
                    if(updateStatus == 1){
                        updateNoti = "Quantity update succeed!";
                    }
                }
                request.setAttribute("INTERIOR_STATUS_UPDATE_NOTI", updateNoti);
                
                InteriorDetailsDAO dao = new InteriorDetailsDAO();
                List<InteriorDetailsDTO> list = dao.listInteriorDetailsByProjectID(projectID);
                request.setAttribute("PROJECT_INTERIOR_LIST", list);
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
