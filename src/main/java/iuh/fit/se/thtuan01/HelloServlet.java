package iuh.fit.se.thtuan01;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(
        name = "paramServlet",
        urlPatterns = {"/param"},
        initParams = {
                @WebInitParam(name = "defaultUser", value = "Guest")
        }
)
public class HelloServlet extends HttpServlet {
    private String defaultUser;

    @Override
    public void init() throws ServletException {
        defaultUser = getServletConfig().getInitParameter("defaultUser");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Lấy context-param
        ServletContext context = getServletContext();
        String appName = context.getInitParameter("appName");

        PrintWriter out = response.getWriter();
        out.println("<h2>Xin chào " + defaultUser + "</h2>");
        out.println("<p>Ứng dụng: " + appName + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = defaultUser;
        }

        PrintWriter out = response.getWriter();
        out.println("<h2>Xin chào " + name + "</h2>");
    }
}
