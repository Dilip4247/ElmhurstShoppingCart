package com.shoppingcart.srv;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/OtpSrv")
public class OtpSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enteredOtp = request.getParameter("otp");
        HttpSession session = request.getSession(false);

        if (session != null) {
            String generatedOtp = (String) session.getAttribute("otp");

            if (enteredOtp != null && enteredOtp.equals(generatedOtp)) {
                // OTP matched, proceed to user home
                RequestDispatcher dispatcher = request.getRequestDispatcher("userHome.jsp");
                dispatcher.forward(request, response);
            } else {
                // OTP mismatch
                response.sendRedirect("otp.jsp?error=Invalid OTP. Please try again.");
            }
        } else {
            response.sendRedirect("login.jsp?message=Session expired. Please login again.");
        }
    }
}
