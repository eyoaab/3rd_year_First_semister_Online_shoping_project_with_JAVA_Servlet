import One.Customer;
import com.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllCustomersServlet")
public class ViewAllCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ArrayList<Customer> customerList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Customer_id, First_name, Last_name, Age, Email, Gender FROM Customer");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Fetched data correctly");

            while (resultSet.next()) {
                int customerId = resultSet.getInt("Customer_id");
                String firstName = resultSet.getString("First_name");
                String lastName = resultSet.getString("Last_name");
                int age = resultSet.getInt("Age");
                String email = resultSet.getString("Email");
                String gender = resultSet.getString("Gender");
                Customer customer = new Customer(firstName, lastName, age, email, null, gender, null);
                customer.setCustomerId(customerId);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            // Log the exception using a logging framework (e.g., SLF4J)
            e.printStackTrace();
        }

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customerList.jsp").forward(request, response);
    }
}
