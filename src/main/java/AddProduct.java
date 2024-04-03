import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBConnection;

@WebServlet("/Admin_add")
public class AddProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        int productPrice = Integer.parseInt(request.getParameter("productPrice"));
        String productImageURL = request.getParameter("productImageURL");
        int productQtty=Integer.parseInt(request.getParameter("productQtty"));
        String category = request.getParameter("category");
        int id=1;
         if (category.equals("Electronics")) {
        	 id=1;
         }
         else if (category.equals("Clothing")){
        	 id=2;
         } 
         else{
        	 id=3;
         }
         Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            // Use the getConnection method from DBConnection class
            con = DBConnection.getConnection();

            String query = "INSERT INTO Product (Product_name, Product_description, Price, Image_url, Quantity_in_stock, Category_id, Created_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productDescription);
            preparedStatement.setInt(3, productPrice);
            preparedStatement.setString(4, productImageURL);
            preparedStatement.setInt(5, productQtty);
            preparedStatement.setInt(6, id);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Failed to insert data into the database");
            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("Admin_add_product.jsp");
    }
}
