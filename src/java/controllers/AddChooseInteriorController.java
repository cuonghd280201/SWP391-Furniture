/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interior.InteriorDAO;
import interior.InteriorDTO;
import interriorDetails.InteriorDetailsDAO;
import interriorDetails.InteriorDetailsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdkhu
 */
@WebServlet(name = "AddChooseInteriorController", urlPatterns = {"/AddChooseInteriorController"})
public class AddChooseInteriorController extends HttpServlet {

    private final String SEARCH_INTERIOR_PAGE = "searchChooseInterior.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = SEARCH_INTERIOR_PAGE;
            try{
                int interiorID = Integer.parseInt(request.getParameter("interiorID"));
                InteriorDetailsDAO dao = new InteriorDetailsDAO();
                InteriorDetailsDTO interiorDetails = dao.getInteriorByID(interiorID);
                int flag = 0;
                
                HttpSession session = request.getSession();
                List<InteriorDetailsDTO> interior_choose = (List<InteriorDetailsDTO>) session.getAttribute("INTERIOR_CHOOSE_LIST");
                if(interior_choose == null){
                    interior_choose = new ArrayList<>();
                }else{
                    for(int i=0; i<= interior_choose.size()-1; i++){
                        int interiorID_ed = interior_choose.get(i).getInteriorID();
                        int quantity_ed = interior_choose.get(i).getInteriorQuantity();
                        if(interiorID_ed == interiorDetails.getInteriorID()){
                            interior_choose.get(i).setInteriorQuantity(quantity_ed + 1);
                            flag++;
                        }
                    }
//                    if(flag == 0 ){
//                        interior_choose.add(interiorDetails);
//                    }
                }
                
                if(flag == 0 ){
                        interior_choose.add(interiorDetails);
                    }
//                interior_choose.add(interiorDetails);
                
//                for(int i=0; i<= interior_choose.size()-1; i++){
//                    int a = interior_choose.get(i).getInteriorID();
//                }
                
                session.setAttribute("INTERIOR_CHOOSE_LIST", interior_choose);
                
                String searchinteriorName = request.getParameter("txtsearchinteriorName");
                if(searchinteriorName == null){
                    searchinteriorName = "";
                }
                List<InteriorDetailsDTO> list = dao.listInterior(searchinteriorName);
                request.setAttribute("INTERIOR_LIST_SEARCH", list);
                url = SEARCH_INTERIOR_PAGE;
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
