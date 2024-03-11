/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interior.InteriorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import orderDetail.OrderDetailDAO;
import project2.ProjectDAO;
import project2.ProjectErrorDTO;
import projectType.ProjectTypeDAO;
import projectType.ProjectTypeDTO;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "SaveProjectController", urlPatterns = {"/SaveProjectController"})
public class SaveProjectController extends HttpServlet {

    private final String SAVE_PROJECT_INFOR_PAGE = "saveProject.jsp";
    private final String MAIN_PAGE = "ProjectDetailsController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = SAVE_PROJECT_INFOR_PAGE;
            String projectName = request.getParameter("projectName");
            String scale = request.getParameter("scale");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String projectTypeID_string = request.getParameter("projectTypeID");
            
            ProjectErrorDTO projectErr = new ProjectErrorDTO();
            boolean errCheck = false;
            
            HttpSession session = request.getSession();
            List<InteriorDTO> interior_choose = (List<InteriorDTO>) session.getAttribute("INTERIOR_CHOOSE_LIST");
            if(interior_choose == null){
                errCheck = true;
                projectErr.setSessionRunOut("Time has run out, Please Add again!");
                request.setAttribute("SAVE_PROJECT_ERROR", projectErr);
            }
            
            try{
                int projectTypeID = Integer.parseInt(projectTypeID_string);
                
                if(projectName.trim().length() <= 1 || projectName.trim().length() > 50){
                    errCheck = true;
                    projectErr.setProjectNameErr("Project Name lenght must from 1 to 50 chars");
                }
            
                if(scale.trim().length() <= 1 || scale.trim().length() > 50){
                    errCheck = true;
                    projectErr.setScaleErr("Scale lenght must from 1 to 50 chars");
                }
                
                if(errCheck){
                    request.setAttribute("SAVE_PROJECT_ERROR", projectErr);
                }else{
                    int userID = 4;
                    ProjectDAO dao = new ProjectDAO();
                    int duplicatedStatus = dao.getProjectByName(projectName);
                    if(duplicatedStatus == 0){
                        LocalDateTime localDateTime = LocalDateTime.now();
                        Timestamp createAt = Timestamp.valueOf(localDateTime);
                        int saveStatus = dao.createProject(projectName, scale, description, image, createAt, 0, userID, projectTypeID);
                        int projectID = dao.getCurrentCreatProjectByUserID(userID, projectName);
                        if(projectID != 0){
                            OrderDetailDAO orderDetailDao = new OrderDetailDAO();
                            List<String> checkAddListOrderDetail = new ArrayList<>();
                            for(InteriorDTO dto : interior_choose){
                                int checkAddSingle = orderDetailDao.createOrderDetail(dto.getInteriorID(), projectID, 1, dto.getUnitPrice(), 1);
                                if(checkAddSingle == 1){
                                    checkAddListOrderDetail.add("Success");
                                }
                            }
                        }
                        if(saveStatus == 1){
                            url = MAIN_PAGE;
                            request.setAttribute("SAVE_NOTI", "1");
                            session.setAttribute("INTERIOR_CHOOSE_LIST", "");
                            
                        }
                    }else{
                        projectErr.setProjectNameExisted("Project "+projectName+" is already existed!");
                        request.setAttribute("SAVE_PROJECT_ERROR", projectErr);
                    }
                }
            }catch(Exception e){
                
            }
            
            ProjectTypeDAO projectTypedao = new ProjectTypeDAO();
            List<ProjectTypeDTO> listProjectType = projectTypedao.listProjectType();
            request.setAttribute("LIST_PROJECT_TYPE", listProjectType);
        
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
            Logger.getLogger(SaveProjectController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SaveProjectController.class.getName()).log(Level.SEVERE, null, ex);
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
