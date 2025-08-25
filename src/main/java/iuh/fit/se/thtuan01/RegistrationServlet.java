package iuh.fit.se.thtuan01;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response, "GET");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response, "POST");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // Không hiển thị
        String facebook = request.getParameter("facebook");
        String gender = request.getParameter("gender");
        String shortBio = request.getParameter("shortBio");

        // Kiểm tra dữ liệu đầy đủ
        if (name != null && !name.isEmpty() && email != null && !email.isEmpty() && gender != null && !gender.isEmpty()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Registration Result</title></head><body>");
            out.println("<h2>Registration Result (" + method + ")</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Facebook: " + (facebook != null ? "Yes" : "No") + "</p>");
            out.println("<p>Gender: " + gender + "</p>");
            out.println("<p>Short Bio: " + (shortBio != null ? shortBio : "Not provided") + "</p>");
            out.println("<p>Password: [Hidden]</p>");
            out.println("<a href='index.html'>Back to Form</a>");
            out.println("</body></html>");
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h2>Error</h2>");
            out.println("<p>Please fill in all required fields (Name, Email, Gender).</p>");
            out.println("<a href='index.html'>Back to Form</a>");
            out.println("</body></html>");
        }
    }
}