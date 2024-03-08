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
    private final String LIST_CUSTOMER_CONTROLLER = "ListCustomerController";
    private final String COUNT_USER_CONTROLLER = "CountUserController";
    private final String SIGUP_CONTROLLER = "SigUpController";
    private final String LIST_STAFF_CONTROLLER = "ListStaffController";
    private final String PROJECT_DETAILS_CONTROLLER = "ProjectDetailsController";
    private final String VIEW_PROJECT_INTERIOR_CONTROLLER = "ProjectInteriorDetailController";
    private final String ADD_CHOOSE_INTERIOR_CONTROLLER = "AddChooseInteriorController";
    private final String SEARCH_INTERIOR_CONTROLLER = "SearchInteriorController";
    private final String SAVE_PROJECT_CONTROLLER = "SaveProjectController";
    private final String CONSTRUCTION_CONTROLLER = "ContructionController";
    private final String CREATE_INQUIRY_CONTROLLER = "CreateInquiryController";

    private final String DISPLAY_USER_PROFILE_CONTROLLER = "DisplayUserProfile";

    private final String HOME_PAGE_CONTROLLER = "DisplayHomePage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String button = request.getParameter("btnAction");
        String url = HOME_PAGE_CONTROLLER;

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
                case "construction":
                    url = CONSTRUCTION_CONTROLLER;
                    break;
                case "DisplayProfile":
                    url = DISPLAY_USER_PROFILE_CONTROLLER;
                    break;
                case "createInquiry":
                    url = CREATE_INQUIRY_CONTROLLER;
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
                case "Add Interior":
                    url = ADD_CHOOSE_INTERIOR_CONTROLLER;
                    break;
                case "Search Interior":
                    url = SEARCH_INTERIOR_CONTROLLER;
                    break;
                case "Save Project":
                    url = SAVE_PROJECT_CONTROLLER;
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
