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
import One.Product_to_show;
@WebServlet("/prepare_product")
public class Customer_view_product extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product_to_show> productList = new ArrayList<>();

        try {
            
            Connection connection = DatabaseConnection.getConnection();
             String sql = "SELECT * FROM Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("Product_id");
                String productName = resultSet.getString("Product_name");
                String productDescription = resultSet.getString("Product_description");
                String imageUrl = resultSet.getString("Image_url");
                int price = resultSet.getInt("Price");

                Product_to_show product = new Product_to_show(productId, productName, productDescription, imageUrl,price);
                productList.add(product);
            }

           
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("productList", productList);
        request.getRequestDispatcher("Customer_view_product.jsp").forward(request, response);
    }
}
