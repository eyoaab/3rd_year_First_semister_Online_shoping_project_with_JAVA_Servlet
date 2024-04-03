import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseConnection;


@WebServlet("/LogInServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection connection = DatabaseConnection.getConnection();

            String selectQuery = "SELECT * FROM Customer WHERE Email = ? AND Customer_password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Initialize session and store customer information
                HttpSession session = request.getSession();
                session.setAttribute("customerId", resultSet.getInt("Customer_id"));
                session.setAttribute("firstName", resultSet.getString("First_name"));
                session.setAttribute("lastName", resultSet.getString("Last_name"));
                session.setAttribute("age", resultSet.getInt("Age"));
                session.setAttribute("email", email);
                session.setAttribute("gender", resultSet.getString("Gender"));

                response.sendRedirect("Customer_home.jsp");
            } else {
                response.sendRedirect("Customer_Log_in.jsp"); 
            }

           
            resultSet.close();
            preparedStatement.close();

          
            DatabaseConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            
            response.sendRedirect("Customer_Log_in.jsp"); 
        }
    }
}
