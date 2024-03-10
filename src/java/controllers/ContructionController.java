package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import inquiry.Construction;
import inquiry.ConstructionDAO;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ContructionController", urlPatterns = {"/ContructionController"})
public class ContructionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Call your DAO to fetch construction data

        ConstructionDAO constructionDAO = new ConstructionDAO();
        List<Construction> constructionList = constructionDAO.getConstructionsDtoList();
        // Set the data in request attribute
        request.setAttribute("constructionList", constructionList);

        // Forward the request to a JSP for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
