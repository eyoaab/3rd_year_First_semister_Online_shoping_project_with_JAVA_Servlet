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
import One.Order;

@WebServlet("/ViewOrdersServlet")
public class ViewOrdersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orders = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();

            String selectQuery = "SELECT * FROM Orders";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

           
            ResultSet resultSet = preparedStatement.executeQuery();

 
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("Order_id"));
                order.setCustomerId(resultSet.getInt("Cust_id"));
                order.setShipmentId(resultSet.getInt("Shipment_id"));
                order.setOrderDate(resultSet.getString("Order_date"));
                order.setOrderTotal(resultSet.getDouble("Order_total"));
                orders.add(order);
            }

           
            resultSet.close();
            preparedStatement.close();

            DatabaseConnection.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
    
            response.sendRedirect("AdminHome.jsp");
            return;
        }

     
        request.setAttribute("orders", orders);

      
        request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
    }
}
