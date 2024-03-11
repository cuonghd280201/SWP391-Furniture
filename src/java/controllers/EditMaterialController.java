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
import material.MaterialErrorDTO;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "EditMaterialController", urlPatterns = {"/EditMaterialController"})
public class EditMaterialController extends HttpServlet {

    private final String MATERIAL_MANAGE_PAGE = "searchMaterial.jsp";
    private final String MATERIAL_CREATE_PAGE = "createMaterial.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String searchMaterialName = request.getParameter("txtsearchMaterialName");
            String materialID_string = request.getParameter("materialID");
            String updateNoti = "";
            String url = MATERIAL_CREATE_PAGE;
            try {
                int materialID = Integer.parseInt(materialID_string);
                String materialName = request.getParameter("materialName");
                String valueLevel_string = request.getParameter("valueLevel");
                String desciprtion = request.getParameter("desciprtion");
                    
                MaterialDAO dao = new MaterialDAO();
                MaterialDTO material = dao.getMaterialByID(materialID);
                if (materialName == null) {
                    url = MATERIAL_CREATE_PAGE;
                    request.setAttribute("MATERIAL_DETAIL", material);
                } else {
                    double valueLevel = 0;
                    if(valueLevel_string != "")
                        valueLevel = Double.parseDouble(valueLevel_string);
                    
                    MaterialErrorDTO materialErr = new MaterialErrorDTO();
                    boolean errCheck = false;
                    
                    if(materialName.trim().length() <= 1 || materialName.trim().length() > 50){
                        errCheck = true;
                        materialErr.setMaterialNameErr("Material Name lenght must from 1 to 50 chars");
                    }
                    
                    if(valueLevel < 1){
                        errCheck = true;
                        materialErr.setValueLevelErr("Value Level must be greater than or equal 1");
                    }
                    
                    MaterialDTO materialEdit = new MaterialDTO(materialID, materialName, valueLevel, desciprtion, material.getStatus());
                    if(errCheck){
                        request.setAttribute("DETAIL_MATERIAL_ERROR", materialErr);
                        request.setAttribute("MATERIAL_DETAIL", materialEdit);
                    }else{
                        int duplicateStatus = dao.getMaterialByName(materialName);
                        if(duplicateStatus == 0){
                            int updateStatus = dao.updateMaterial(materialEdit);
                            url = MATERIAL_MANAGE_PAGE;
                            updateNoti = "Update "+materialName+" succeed!";
                        }else{
                            url = MATERIAL_CREATE_PAGE;
                            materialErr.setMaterialNameExisted("Material "+materialName+" is already existed!");
                            request.setAttribute("DETAIL_MATERIAL_ERROR", materialErr);
                            request.setAttribute("MATERIAL_DETAIL", materialEdit);
                        }
                    }
                    
                    
                    
                    if (searchMaterialName == null) {
                        searchMaterialName = "";
                    }
                    List<MaterialDTO> list = dao.listMaterial(searchMaterialName);
                    request.setAttribute("MATERIAL_LIST_SEARCH", list);
                }
                request.setAttribute("MATERIAL_STATUS_UPDATE_NOTI", updateNoti);
            } catch (Exception e) {

            } finally {
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
