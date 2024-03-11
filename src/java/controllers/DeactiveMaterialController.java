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
import material.MaterialDAO;
import material.MaterialDTO;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "DeactiveMaterialController", urlPatterns = {"/DeactiveMaterialController"})
public class DeactiveMaterialController extends HttpServlet {

    private final String MATERIAL_MANAGE_PAGE = "searchMaterial.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String searchMaterialName = request.getParameter("txtsearchMaterialName");
            String materialID_string = request.getParameter("materialID");
            String updateNoti = "";
            String url = MATERIAL_MANAGE_PAGE;
            try{
                int materialID = Integer.parseInt(materialID_string);
                MaterialDAO dao = new MaterialDAO();
                MaterialDTO material = dao.getMaterialByID(materialID);
                updateNoti = "Change "+material.getMaterialName()+" Status failed!";
                if(material != null){
                    int materialStatus = material.getStatus();
                    if(materialStatus == 0){
                        material.setStatus(1);
                    }else if(materialStatus == 1){
                        material.setStatus(0);
                    }
                    int updateStatus = dao.updateMaterial(material);
                    if(updateStatus == 1){
                        updateNoti = "Change "+material.getMaterialName()+" Status succeed!";
                    }
                }
                
                if(searchMaterialName == null){
                    searchMaterialName = "";
                }
                
                List<MaterialDTO> list = dao.listMaterial(searchMaterialName);
                request.setAttribute("MATERIAL_STATUS_UPDATE_NOTI", updateNoti);
                request.setAttribute("MATERIAL_LIST_SEARCH", list);
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
