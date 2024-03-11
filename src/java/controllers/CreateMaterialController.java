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
@WebServlet(name = "CreateMaterialController", urlPatterns = {"/CreateMaterialController"})
public class CreateMaterialController extends HttpServlet {

    private final String MATERIAL_CREATE_PAGE = "createMaterial.jsp";
    private final String MATERIAL_MANAGE_PAGE = "searchMaterial.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String materialName = request.getParameter("materialName");
            String valueLevel_string = request.getParameter("valueLevel");
            String desciprtion = request.getParameter("desciprtion");
            String updateNoti = "";
            String url = MATERIAL_CREATE_PAGE;
            try {
                if (materialName != null && valueLevel_string != null && desciprtion != null) {
                    double valueLevel = 0;
                    if (valueLevel_string != "" && valueLevel_string != null) {
                        valueLevel = Double.parseDouble(valueLevel_string);
                    }
                MaterialErrorDTO materialErr = new MaterialErrorDTO();
                boolean errCheck = false;

                if (materialName.trim().length() <= 1 || materialName.trim().length() > 50) {
                    errCheck = true;
                    materialErr.setMaterialNameErr("Material Name lenght must from 1 to 50 chars");
                }

                if (valueLevel < 1) {
                    errCheck = true;
                    materialErr.setValueLevelErr("Value Level must be greater than or equal 1");
                }
                MaterialDTO materialEdit = new MaterialDTO(1, materialName, valueLevel, desciprtion, 1);
                if (errCheck) {
                    request.setAttribute("DETAIL_MATERIAL_ERROR", materialErr);
                    request.setAttribute("MATERIAL_DETAIL", materialEdit);
                } else {
                    MaterialDAO dao = new MaterialDAO();
                    int duplicateStatus = dao.getMaterialByName(materialName);
                    if (duplicateStatus == 0) {
                        int createStatus = dao.createMaterial(materialName, valueLevel, desciprtion);
                        url = MATERIAL_MANAGE_PAGE;
                        updateNoti = "Create New Material succeed!";

                        List<MaterialDTO> list = dao.listMaterial("");
                        request.setAttribute("MATERIAL_LIST_SEARCH", list);
                    } else {
                        url = MATERIAL_CREATE_PAGE;
                        materialErr.setMaterialNameExisted("Material " + materialName + " is already existed!");
                        request.setAttribute("DETAIL_MATERIAL_ERROR", materialErr);
                        request.setAttribute("MATERIAL_DETAIL", materialEdit);
                    }
                }
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
