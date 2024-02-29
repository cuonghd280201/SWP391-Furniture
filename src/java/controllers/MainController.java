// MainController.java
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LOGIN_CONTROLLER = "LoginController";
    private final String LOGOUT_CONTROLLER = "LogoutController";
    private final String HOME_CONTROLLER = "HomeController";
    private final String LIST_CUSTOMER_CONTROLLER = "ListCustomerController";
    private final String COUNT_USER_CONTROLLER = "CountUserController";
    private final String SIGUP_CONTROLLER = "SigUpController";
    private final String LIST_STAFF_CONTROLLER = "ListStaffController";
    
    private final String PROJECT_DETAILS_CONTROLLER = "ProjectDetailsController";
    private final String VIEW_PROJECT_INTERIOR_CONTROLLER = "ProjectInteriorController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String button = request.getParameter("btnAction");
        String url = HOME_CONTROLLER;

        if (button != null) {
            switch (button) {
                case "Login":
                    url = LOGIN_CONTROLLER;
                    break;
                case "Login Back":
                    url = "login.jsp";
                    break;
                case "Logout":
                    url = LOGOUT_CONTROLLER;
                    break;
                case "ListCustomer":
                    url = LIST_CUSTOMER_CONTROLLER;
                    break;
                case "ListStaff":
                    url = LIST_STAFF_CONTROLLER;
                    break;
                case "CountUser":
                    url = COUNT_USER_CONTROLLER;
                    break;

                case "SignUp":
                    url = SIGUP_CONTROLLER;
                    break;
                case "Show":
                    url = PROJECT_DETAILS_CONTROLLER;
                    break;
                case "ViewProject":
                    url = VIEW_PROJECT_INTERIOR_CONTROLLER;
                    break;
                default:
                    break;
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
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
        return "Main Controller Servlet";
    }
}
