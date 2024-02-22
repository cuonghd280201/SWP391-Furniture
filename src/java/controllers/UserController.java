/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UserDTO;
import users.UserDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = String.valueOf(request.getAttribute("action"));
        String controller = String.valueOf(request.getAttribute("controller"));
        switch (action) {
            case "register":
                break;
            case "login":
                break;
            case "logining":
                login(request, response);
                break;
            case "signUp":
                signUp(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            default:
                request.setAttribute("controller", "error");
                request.setAttribute("action", "index");
                request.setAttribute("message", "error");
        }
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);

    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String email = request.getParameter("email");
        String password = request.getParameter("password");
        String total = request.getParameter("total");
        String result;
        UserDAO uf = new UserDAO();
        UserDTO u = uf.checkLogin(email, password);
        if (u == null) {
            result = "Login failed! username or password is incorrect";
            request.setAttribute("result", result);
            request.getRequestDispatcher("/user/login.vn").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", u);
            request.setAttribute("total", total);
            request.getRequestDispatcher("/home/index.vn").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/views/home/index.jsp");
    }

    protected void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("su-password");
        String rePassword = request.getParameter("re-su-password");
        Random generator = new Random();
        String randomId = "u" + String.valueOf(generator.nextInt(999999));

        if (!password.equals(rePassword)) {
            request.setAttribute("result", "Passwords do not match!");
            request.getRequestDispatcher("/user/login.vn").forward(request, response);
        } else {
            UserDAO uf = new UserDAO();

            UserDTO u = uf.checkAccountExist(email);
            if (u == null) {
                u = new UserDTO();
                u.setUserId(randomId);
                u.setEmail(email);
                u.setPassword(password);
                request.setAttribute("user", u);

                if (uf.signUp(u)) {
                    request.getRequestDispatcher("/user/login.vn").forward(request, response);
                    return;
                } else {
                    request.setAttribute("result", "Can't insert this account.");
                    request.getRequestDispatcher("/user/login.vn").forward(request, response);
                }
            } else {
                request.setAttribute("result", "Email already exists!");
                request.getRequestDispatcher("/user/login.vn").forward(request, response);
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
