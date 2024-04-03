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
import com.DatabaseConnection;
import One.OrderDetail;

@WebServlet("/ViewOrderDetailsServlet")
public class ViewOrderDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<OrderDetail> orderDetails = new ArrayList<>();

        try {
            // Get connection from DatabaseConnection class
            Connection connection = DatabaseConnection.getConnection();

            // SQL query to fetch order details
            String selectQuery = "SELECT DISTINCT " +
                    "C.First_name AS FirstName, " +
                    "C.Last_name AS LastName, " +
                    "P.Product_name AS ProductName, " +
                    "O.Order_date AS OrderDate, " +
                    "O.Order_total AS OrderTotal, " +
                    "OI.Quantity AS Quantity " +
                    "FROM Orders O " +
                    "JOIN Order_item OI ON O.Order_id = OI.Order_id " +
                    "JOIN Product P ON OI.Product_id = P.Product_id " +
                    "JOIN Customer C ON O.Cust_id = C.Customer_id";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set and populate the list of order details
            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setFirstName(resultSet.getString("FirstName"));
                orderDetail.setLastName(resultSet.getString("LastName"));
                orderDetail.setProductName(resultSet.getString("ProductName"));
                orderDetail.setOrderDate(resultSet.getString("OrderDate"));
                orderDetail.setOrderTotal(resultSet.getDouble("OrderTotal"));
                orderDetail.setQuantity(resultSet.getInt("Quantity"));
                orderDetails.add(orderDetail);
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();

            // Close the connection using DatabaseConnection class
            DatabaseConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            // Handle database connection or query execution errors
            response.sendRedirect("AdminHome.jsp"); // Change "error.jsp" to your desired error page
            return;
        }

        // Set the list of order details as a request attribute
        request.setAttribute("orderDetails", orderDetails);

        // Forward the request to the JSP page
        request.getRequestDispatcher("orderDetails.jsp").forward(request, response);
    }
}
