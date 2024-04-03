import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import One.Product1;
import com.DatabaseConnection;

@WebServlet("/AdminViewProduct")
public class Product_for_adminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        List<Product1> productList = getAllProducts();

    
        request.setAttribute("productList", productList);

        
        request.getRequestDispatcher("/product_for_admin.jsp").forward(request, response);
    }

    private List<Product1> getAllProducts() {
        List<Product1> productList = new ArrayList<>();

     

        try (Connection connection = DatabaseConnection.getConnection()) {
           
            String query = "SELECT * FROM Product";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
               
                while (resultSet.next()) {
                    Product1 product = new Product1();
                    product.setProductId(resultSet.getInt("Product_id"));
                    product.setProductName(resultSet.getString("Product_name"));
                    product.setProductDescription(resultSet.getString("Product_description"));
                    product.setPrice(resultSet.getDouble("Price"));
                    product.setImageUrl(resultSet.getString("Image_url"));
                    product.setQuantityInStock(resultSet.getInt("Quantity_in_stock"));
                    product.setCategoryId(resultSet.getInt("Category_id"));
                    product.setCreatedDate(resultSet.getString("Created_date"));

                    productList.add(product);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
}
