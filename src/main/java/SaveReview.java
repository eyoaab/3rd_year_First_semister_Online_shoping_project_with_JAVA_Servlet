import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.DatabaseConnection;

@WebServlet("/SaveReviewServlet")
public class SaveReview extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve review parameters
        String description = request.getParameter("description");
        int rating = Integer.parseInt(request.getParameter("rating"));

        // Retrieve customer email from session
        HttpSession session = request.getSession();
        String customerEmail = (String) session.getAttribute("email");

        // Retrieve product ID from the hidden input
        String selectedProductIdString = request.getParameter("selectedProductId");
        int productId;

        try {
            if (selectedProductIdString != null && !selectedProductIdString.isEmpty()) {
                productId = Integer.parseInt(selectedProductIdString);
            } else {
                // Handle the case where the parameter is empty or not provided
                throw new NumberFormatException("Selected product ID is empty or not provided");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            // Redirect to an error page or take appropriate action
            response.sendRedirect("Customer_Review_page.jsp");
            return;
        }
        try {
            // Get connection from DatabaseConnection class
            Connection connection = DatabaseConnection.getConnection();

            // Retrieve customer ID from the database based on the email
            int customerId = getCustomerIdByEmail(connection, customerEmail);

            // Check if the customer and product exist before saving the review
            if (customerId != -1 && isProductExists(connection, productId)) {
                // SQL query to save customer review
                String insertQuery = "INSERT INTO Review (Cust_id, Product_id, Rating, Review_description, Review_date) " +
                                     "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, customerId);
                preparedStatement.setInt(2, productId);
                preparedStatement.setInt(3, rating);
                preparedStatement.setString(4, description);

                // Get current date and time
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentDate = sdf.format(new Date());
                preparedStatement.setString(5, currentDate);

                // Execute the query
                preparedStatement.executeUpdate();

                // Close the resources
                preparedStatement.close();

                // Close the connection using DatabaseConnection class
                DatabaseConnection.closeConnection();

                // Redirect to a page after saving the review (e.g., a thank you page)
                response.sendRedirect("Customer_home.jsp");
            } else {
                // Redirect to an error page if customer or product doesn't exist
                response.sendRedirect("Customer_Review_page.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Handle database connection or query execution errors
            response.sendRedirect("Customer_Review_page.jsp"); // Change "ErrorPage.jsp" to your desired error page
        }
    }

    private int getCustomerIdByEmail(Connection connection, String email) throws SQLException {
        String query = "SELECT Customer_id FROM Customer WHERE Email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Customer_id");
                }
            }
        }
        return -1; // Return -1 if customer not found
    }

    private boolean isProductExists(Connection connection, int productId) throws SQLException {
        String query = "SELECT * FROM Product WHERE Product_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}
