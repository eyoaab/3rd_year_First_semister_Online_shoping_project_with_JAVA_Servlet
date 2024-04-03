import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseConnection;
import One.Product;

@WebServlet("/nameServer")
public class Product_Name_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = retrieveProductsFromDatabase();

        request.setAttribute("products", products);
        request.getRequestDispatcher("/Customer_Review_page.jsp").forward(request, response);
    }

    private List<Product> retrieveProductsFromDatabase() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT Product_id, Product_name FROM Product";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int productId = resultSet.getInt("Product_id");
                    //System.out.println(productId);
                    String productName = resultSet.getString("Product_name");
                   // System.out.println(productName);
                    Product product = new Product(productId, productName);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            DatabaseConnection.closeConnection(); 
        }

        return products;
    }
}
