<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>OTP Verification</title>
</head>
<body>
    <h2>Enter the OTP sent to your email</h2>

    <form action="OtpSrv" method="post">
        <input type="text" name="otp" placeholder="Enter OTP" required />
        <br><br>
        <input type="submit" value="Verify OTP" />
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;"><%= request.getParameter("error") %></p>
    <% } %>
</body>
</html>
