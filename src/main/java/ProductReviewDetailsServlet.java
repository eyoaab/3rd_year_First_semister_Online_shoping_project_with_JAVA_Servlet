import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import One.ProductReviewDetails;
import com.DatabaseConnection;

@WebServlet("/ProductReviewDetailsServlet")
public class ProductReviewDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProductReviewDetails> productReviews = getProductReviewsFromDatabase(); // Fetch data from the database

        request.setAttribute("productReviews", productReviews);
        request.getRequestDispatcher("Review_history.jsp").forward(request, response);
    }

    // Fetch data from the database
    private List<ProductReviewDetails> getProductReviewsFromDatabase() {
        List<ProductReviewDetails> productReviews = new ArrayList<>();

        // Replace these values with your actual database information
       

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT p.product_name, r.Rating, r.Review_date, r.Review_description, c.First_name, c.Last_name, c.Email " +
                         "FROM Product p " +
                         "JOIN Review r ON p.Product_id = r.Product_id " +
                         "JOIN Customer c ON r.Cust_id = c.Customer_id";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String productName = resultSet.getString("product_name");
                    int rating = resultSet.getInt("Rating");
                    Date reviewDate = resultSet.getDate("Review_date");
                    String reviewDescription = resultSet.getString("Review_description");
                    String customerFirstName = resultSet.getString("First_name");
                    String customerLastName = resultSet.getString("Last_name");
                    String email = resultSet.getString("Email");

                    ProductReviewDetails review = new ProductReviewDetails(
                            productName, rating, reviewDate, reviewDescription, customerFirstName, customerLastName, email);

                    productReviews.add(review);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real application
        }

        return productReviews;
    }
}
