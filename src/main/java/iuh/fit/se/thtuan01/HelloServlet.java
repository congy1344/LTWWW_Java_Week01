package iuh.fit.se.thtuan01;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class HelloServlet extends HttpServlet {
    private String defaultUser;
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        defaultUser = config.getInitParameter("defaultUser");
        context = config.getServletContext();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String appName = context.getInitParameter("appName");

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Servlet Result</title></head><body>");
        out.println("<h1>" + appName + "</h1>");
        if (username != null && !username.isEmpty()) {
            out.println("<p>Welcome, " + username + "! (Default: " + defaultUser + ")</p>");
        } else {
            out.println("<p>No username provided. Default: " + defaultUser + "</p>");
        }
        out.println("<a href='index.jsp'>Back to Form</a>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
