public class OrderDetail {
    private String firstName;
    private String lastName;
    private String productName;
    private String orderDate;
    private double orderTotal;
    private int quantity;

    // Constructors
    public OrderDetail() {
    }

    public OrderDetail(String firstName, String lastName, String productName, String orderDate, double orderTotal, int quantity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productName = productName;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.quantity = quantity;
    }

    // Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
