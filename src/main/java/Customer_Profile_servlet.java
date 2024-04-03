import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class Customer_Profile_servlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("email") != null) {
            String email = (String) session.getAttribute("email");

            
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                String url = "jdbc:mysql://your_database_host:your_database_port/online_shoping";
                String username = "root";
                String password = "eyob";
                
                conn = DriverManager.getConnection(url, username, password);

                String query = "SELECT * FROM Customer WHERE Email=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, email);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Retrieve user information
                    int customerId = rs.getInt("Customer_id");
                    String firstName = rs.getString("First_name");
                    String lastName = rs.getString("Last_name");
                    int age = rs.getInt("Age");
                    String gender = rs.getString("Gender");

                    // Set user information as request attributes
                    request.setAttribute("customerId", customerId);
                    request.setAttribute("firstName", firstName);
                    request.setAttribute("lastName", lastName);
                    request.setAttribute("age", age);
                    request.setAttribute("gender", gender);

                    // Forward the request to the profile.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Customer_profile.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close database connections
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
