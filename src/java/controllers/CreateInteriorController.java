/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interior.InteriorDAO;
import interior.InteriorDTO;
import interior.InteriorErrorDTO;
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
import material.MaterialDAO;
import material.MaterialDTO;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "CreateInteriorController", urlPatterns = {"/CreateInteriorController"})
public class CreateInteriorController extends HttpServlet {

    private final String INTERIOR_CREATE_PAGE = "createInterior.jsp";
    private final String INTERIOR_MANAGE_PAGE = "searchInterior.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String interiorName = request.getParameter("interiorName");
            String size_string = request.getParameter("size");
            String mass_string = request.getParameter("mass");
            String unitPrice_string = request.getParameter("unitPrice");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String materialID_string = request.getParameter("materialID");
            String updateNoti = "";
            String url = INTERIOR_CREATE_PAGE;
            try {
                MaterialDAO materialDao = new MaterialDAO();
                List<MaterialDTO> materialList = materialDao.listMaterial("");
                request.setAttribute("MATERIAL_LIST", materialList);
                
                if (interiorName != null && size_string != null) {
                    int size = 0;
                    if (size_string != "" && size_string != null) {
                        size = Integer.parseInt(size_string);
                    }
                    
                    double mass = 0.0;
                    if (mass_string != "" && mass_string != null) {
                        mass = Double.parseDouble(mass_string);
                    }
                    
                    double unitPrice = 0.0;
                    if (unitPrice_string != "" && unitPrice_string != null) {
                        unitPrice = Double.parseDouble(unitPrice_string);
                    }
                    
                    int materialID = 0;
                    if (materialID_string != "" && materialID_string != null) {
                        materialID = Integer.parseInt(materialID_string);
                    }
                InteriorErrorDTO interiorErr = new InteriorErrorDTO();
                boolean errCheck = false;

                if (interiorName.trim().length() < 1 || interiorName.trim().length() > 50) {
                    errCheck = true;
                    interiorErr.setInteriorNameErr("Interior Name lenght must from 1 to 50 chars");
                }

                if (size < 1) {
                    errCheck = true;
                    interiorErr.setSizeErr("Size must be greater than or equal 1");
                }
                
                if (mass < 1) {
                    errCheck = true;
                    interiorErr.setMassErr("Mass must be greater than or equal 1");
                }
                
                if (unitPrice <= 0 ) {
                    errCheck = true;
                    interiorErr.setUnitPriceErr("Unit Price must be greater than 0");
                }
                
                if (description.trim().length() > 200) {
                    errCheck = true;
                    interiorErr.setDescriptionErr("Description lenght must less than 200 chars");
                }
                
                InteriorDTO interiorEdit = new InteriorDTO(0, interiorName, size, 0, mass, unitPrice, 0.0, description, image, 0, null, null, 1, materialID);
                if (errCheck) {
                    request.setAttribute("DETAIL_INTERIOR_ERROR", interiorErr);
                    request.setAttribute("INTERIOR_DETAIL", interiorEdit);
                } else {
                    InteriorDAO dao = new InteriorDAO();
                    int duplicateStatus = dao.getInteriorByName(interiorName);
                    if (duplicateStatus == 0) {
                        LocalDateTime localDateTime = LocalDateTime.now();
                        Timestamp createAt = Timestamp.valueOf(localDateTime);
                        int createStatus = dao.createInterior(interiorName, size, mass, unitPrice, description, image, createAt, materialID);
                        url = INTERIOR_MANAGE_PAGE;
                        updateNoti = "Create New Interior succeed!";

                        InteriorDetailsDAO daoD = new InteriorDetailsDAO();
                        List<InteriorDetailsDTO> list = daoD.listInterior("");
                        request.setAttribute("INTERIOR_LIST_SEARCH", list);
                    } else {
                        url = INTERIOR_CREATE_PAGE;
                        interiorErr.setInteriorExisted("Interior " + interiorName + " is already existed!");
                        request.setAttribute("DETAIL_INTERIOR_ERROR", interiorErr);
                        request.setAttribute("INTERIOR_DETAIL", interiorEdit);
                    }
                }
                }
                request.setAttribute("INTERIOR_STATUS_UPDATE_NOTI", updateNoti);
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
