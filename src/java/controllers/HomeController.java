package controllers;

import projects.Project;
import projects.ProjectFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = String.valueOf(request.getAttribute("action"));
        String controller = String.valueOf(request.getAttribute("controller"));
        switch (action) {
            case "index":
                listProjects(request, response);
                break;
            default:
               request.setAttribute("controller", "error");
                request.setAttribute("action", "index");
                request.setAttribute("message", "error");
        }
                request.getRequestDispatcher(config.Config.LAYOUT).forward(request, response);

    }

     protected void listProjects(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ProjectFacade projectFacade = new ProjectFacade();
            List<Project> projects = projectFacade.selectAllProjects();
            request.setAttribute("listProjects", projects);
    }

    // Other methods as needed
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
