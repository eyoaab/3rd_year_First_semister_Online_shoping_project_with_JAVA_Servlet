import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginServlet")
public class Admin_log_in extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValidUser = "admin".equals(username) && "admin".equals(password);

        if (isValidUser) {
           
            response.sendRedirect("AdminHome.jsp");
        } else {
            response.sendRedirect("admin-login.jsp?error=1");
        }
    }
}
