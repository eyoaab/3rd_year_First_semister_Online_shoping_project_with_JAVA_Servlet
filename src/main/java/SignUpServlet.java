import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DatabaseConnection;

@WebServlet("/signup_Servlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("First_name");
        String lastName = request.getParameter("Last_name");
        int age = Integer.parseInt(request.getParameter("Age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("Gender");

        try {
            // Get connection from DatabaseConnection class
            Connection connection = DatabaseConnection.getConnection();

            // SQL query to insert data into the customer table
            //INSERT INTO Customer (First_name, Last_name, Age, Email, Customer_password, Gender, Registration_date )VALUES('Kiya', 'kebe', 12, 'kiya@kiya', 'weee', 'Male', CURRENT_TIMESTAMP);

            String insertQuery = "INSERT INTO Customer (First_name, Last_name, Age, Email, Customer_password, Gender,Registration_date) VALUES (?, ?, ?, ?, ?, ?,CURRENT_TIMESTAMP)";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, gender);

            // Execute the query to insert data
            preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();

            // Close the connection using DatabaseConnection class
            DatabaseConnection.closeConnection();

            // Redirect to a success page or login page
            response.sendRedirect("Customer_Log_in.jsp"); // Change "success.jsp" to your desired success page
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database connection or query execution errors
            response.sendRedirect("Signup.jsp"); // Change "error.jsp" to your desired error page
        }
    }
}
