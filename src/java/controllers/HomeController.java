// HomeController.java
package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projects.Project;
import projects.ProjectFacade;

@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    private final String HOME_PAGE_USER = "index.jsp";
    private final String ERROR_PAGE = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ProjectFacade projectFacade = new ProjectFacade();
            List<Project> projects = projectFacade.selectAllProjects();
            request.setAttribute("listProjects", projects);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error retrieving projects: " + e.getMessage());
            RequestDispatcher errorDispatcher = request.getRequestDispatcher(ERROR_PAGE);
            errorDispatcher.forward(request, response);
            return;
        }
        RequestDispatcher rd = request.getRequestDispatcher(HOME_PAGE_USER);
        rd.forward(request, response);
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
        return "Home Controller Servlet";
    }
}
