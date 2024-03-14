package controllers;

import inquiry.Inquiry;
import inquiry.InquiryDAO;
import inquiry.InquiryErrorDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDTO;
import utils.AppContants;
import notifications.NotificationDAO;

@WebServlet(name = "CreateInquiryController", urlPatterns = {"/CreateInquiryController"})
public class CreateInquiryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");

        String url = siteMaps.getProperty(AppContants.CreateInquiryFeature.ERROR_PAGE);
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("USER");

        if (user == null) {
            url = siteMaps.getProperty(AppContants.LoginFeatures.LOGIN_PAGE);
            response.sendRedirect(url);
            return;
        }

        int userID = user.getUserId();
        String inquiryTittle = request.getParameter("txtInquiryTittle");
        int constructionID = Integer.parseInt(request.getParameter("txtConstructionID"));
        int scaleID = Integer.parseInt(request.getParameter("txtScaleID"));
        int projectTypeID = Integer.parseInt(request.getParameter("txtProjectTypeID"));
        int priceRangeID = Integer.parseInt(request.getParameter("txtPriceRangeID"));
        String description = request.getParameter("txtDescription");
        InquiryErrorDTO error = new InquiryErrorDTO();
        boolean flag = true;

        if (inquiryTittle == null || inquiryTittle.trim().isEmpty()) {
            error.setInquiryTitleRequired("Inquiry title is required.");
            flag = false;
        }

        if (description.length() > 2000) {
            error.setDescriptionExceedCharsCount("The description must not exceed 2000 characters.");
            flag = false;
        }

        if (!flag) {
            request.setAttribute("ERROR", error);
            url = siteMaps.getProperty(AppContants.LoginFeatures.DISPLAY_HOME_PAGE_CONTROLLER);
        } else {
            try {

                Inquiry inquiry = new Inquiry(userID, inquiryTittle, constructionID, scaleID, projectTypeID, priceRangeID, description);
                InquiryDAO inquiryDAO = new InquiryDAO();
                boolean resultInsertInquiry = inquiryDAO.insertInquiry(inquiry);
                if (resultInsertInquiry) {
                    NotificationDAO notificationDAO = new NotificationDAO();
                    notificationDAO.insertNotification(userID, "There was a quote request just arrived,please check it!!.");
                    // Set success notification
                    request.getSession().setAttribute("SAVE_NOTI", "success");
                    url = siteMaps.getProperty(AppContants.DisplayInquiryFeartures.DISPLAY_INQUIRY_CUS_CONTROLLER);

                }

            } catch (SQLException ex) {
                Logger.getLogger(CreateInquiryController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                response.sendRedirect(url);
            }
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
        return "Short description";
    }
}
