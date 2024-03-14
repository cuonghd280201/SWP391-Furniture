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
    
    private final String SEARCH_PROJECT_CUSTOMER_CONTROLLER = "SearchProjectCController";
    private final String VIEW_PROJECT_INTERIOR_CONTROLLER = "ProjectInteriorDetailController";
    
    private final String ADD_CHOOSE_INTERIOR_CONTROLLER = "AddChooseInteriorController";
    private final String SEARCH_CHOOSE_INTERIOR_CONTROLLER = "SearchChooseInteriorController";
    private final String SAVE_PROJECT_CONTROLLER = "SaveProjectController";
    
    private final String SEARCH_MATERIAL_CONTROLLER = "SearchMaterialController";
    private final String CREATE_MATERIAL_CONTROLLER = "CreateMaterialController";
    private final String EDIT_MATERIAL_CONTROLLER = "EditMaterialController";
    private final String DEACTIVE_MATERIAL_CONTROLLER = "DeactiveMaterialController";
    private final String DETAIL_MATERIAL_CONTROLLER = "DetailMaterialController";
    
    private final String SEARCH_INTERIOR_CONTROLLER = "SearchInteriorController";
    private final String CREATE_INTERIOR_CONTROLLER = "CreateInteriorController";
    private final String EDIT_INTERIOR_CONTROLLER = "EditInteriorController";
    private final String DEACTIVE_INTERIOR_CONTROLLER = "DeactiveInteriorController";
    private final String DETAIL_INTERIOR_CONTROLLER = "DetailInteriorController";
    
    private final String SEARCH_PROJECT_CONTROLLER = "SearchProjectController";
    private final String CREATE_PROJECT_CONTROLLER = "CreateProjectController";
    private final String EDIT_PROJECT_CONTROLLER = "EditProjectController";
    private final String EDIT_PROJECT_INTERIOR_QUANTITY_CONTROLLER = "EditProjectInteriorQuantityController";
    private final String EDIT_PROJECT_INTERIOR_REMOVE_CONTROLLER = "EditProjectInteriorRemoveController";
    private final String DEACTIVE_PROJECT_CONTROLLER = "DeactiveProjectController";
    private final String DETAIL_PROJECT_CONTROLLER = "DetailProjectController";

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
                    url = SEARCH_PROJECT_CUSTOMER_CONTROLLER;
                    break;
                case "ViewProject":
                    url = VIEW_PROJECT_INTERIOR_CONTROLLER;
                    break;
                case "Add Interior":
                    url = ADD_CHOOSE_INTERIOR_CONTROLLER;
                    break;
                case "Search Choose Interior":
                    url = SEARCH_CHOOSE_INTERIOR_CONTROLLER;
                    break;
                case "Save Project":
                    url = SAVE_PROJECT_CONTROLLER;
                    break;
                    
                case "Search Material":
                    url = SEARCH_MATERIAL_CONTROLLER;
                    break;
                case "Create Material":
                    url = CREATE_MATERIAL_CONTROLLER;
                    break;
                case "Edit Material":
                    url = EDIT_MATERIAL_CONTROLLER;
                    break;
                case "Deactivate Material":
                    url = DEACTIVE_MATERIAL_CONTROLLER;
                    break; 
                
                case "Search Interior":
                    url = SEARCH_INTERIOR_CONTROLLER;
                    break;
                case "Create Interior":
                    url = CREATE_INTERIOR_CONTROLLER;
                    break;
                case "Edit Interior":
                    url = EDIT_INTERIOR_CONTROLLER;
                    break;
                case "Deactivate Interior":
                    url = DEACTIVE_INTERIOR_CONTROLLER;
                    break;
                    
                case "Search Project":
                    url = SEARCH_PROJECT_CONTROLLER;
                    break;
                case "Edit Project":
                    url = EDIT_PROJECT_CONTROLLER;
                    break;
                case "Edit Quantity":
                    url = EDIT_PROJECT_INTERIOR_QUANTITY_CONTROLLER;
                    break;
                case "Remove Interior":
                    url = EDIT_PROJECT_INTERIOR_REMOVE_CONTROLLER;
                    break;
                case "View Project":
                    url = DETAIL_PROJECT_CONTROLLER;
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
