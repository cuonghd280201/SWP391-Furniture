/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vnpay.config;
import project2.ProjectDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));

        // Các thông tin cần truyền đến trang thanh toán của VNPAY
        String vnpUrl = config.vnp_PayUrl;
        String vnpReturnUrl = config.vnp_Returnurl;
        String vnpTmnCode = config.vnp_TmnCode;
        String vnpHashSecret = config.vnp_HashSecret;

        // Tạo một map chứa các thông tin cần truyền đến trang thanh toán của VNPAY
        Map<String, String> params = new HashMap<>();
        params.put("vnp_Version", "2.0.0");
        params.put("vnp_Command", "pay");
        params.put("vnp_TmnCode", vnpTmnCode);
        params.put("vnp_Locale", "vn");
        params.put("vnp_CurrCode", "VND");
        params.put("vnp_OrderType", "billpayment");
        params.put("vnp_ReturnUrl", vnpReturnUrl);
        params.put("vnp_Amount", String.valueOf(totalMoney));

        // Tạo chuỗi hash để bảo mật thông tin
        String secureHash = config.hashAllFields(params);

        // Thêm chuỗi hash vào map
        params.put("vnp_SecureHashType", "SHA256");
        params.put("vnp_SecureHash", secureHash);

        // Chuyển các tham số sang dạng chuỗi query
        StringBuilder urlParams = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            urlParams.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            urlParams.append("=");
            urlParams.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            urlParams.append("&");
        }

        // Tạo URL hoàn chỉnh cho trang thanh toán
        String paymentUrl = vnpUrl + "?" + urlParams.toString();

        // Chuyển hướng người dùng đến trang thanh toán của VNPAY
        response.sendRedirect(paymentUrl);
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
