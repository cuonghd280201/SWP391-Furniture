package controllers;

import inquiry.Construction;
import inquiry.ConstructionDAO;
import inquiry.PriceRange;
import inquiry.PriceRangeDAO;
import inquiry.ProjectType;
import inquiry.ProjectTypeDAO;
import inquiry.Scale;
import inquiry.ScaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projects.Project;
import projects.ProjectFacade;

@WebServlet(name = "LoadHomePageController", urlPatterns = {"/LoadHomePageController"})
public class LoadHomePageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);
            ConstructionDAO constructionDAO = new ConstructionDAO();
            constructionDAO.loadAllContruction();
            List<Construction> constructionList = constructionDAO.getConstructionsDtoList();
            // Set the data in request attribute
            request.setAttribute("constructionList", constructionList);

            ProjectFacade projectFacade = new ProjectFacade();
            List<Project> projects = projectFacade.selectAllProjects();
            session.setAttribute("listProjects", projects);

            ScaleDAO scaleDAO = new ScaleDAO();
            scaleDAO.loadAllScale();
            List<Scale> scaleList = scaleDAO.getScalesDtoList();
            request.setAttribute("scaleList", scaleList);

            PriceRangeDAO priceRangeDAO = new PriceRangeDAO();
            priceRangeDAO.loadAllPriceRange();
            List<PriceRange> priceList = priceRangeDAO.getPriceRangesDtoList();
            request.setAttribute("priceList", priceList);

            ProjectTypeDAO projectTypeDAO = new ProjectTypeDAO();
            projectTypeDAO.loadAllProjectType();
            List<ProjectType> projectTypeList = projectTypeDAO.getProjectTypesDtoList();
            request.setAttribute("projectTypeList", projectTypeList);

        } catch (Exception ex) {
            Logger.getLogger(LoadHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            // Forwarding the request to an error page
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
        return "Loads the home page of the web application";
    }
}
