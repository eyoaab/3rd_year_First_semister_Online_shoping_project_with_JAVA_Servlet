package One;
public class Order {
    private int orderId;
    private int customerId;
    private int shipmentId;
    private String orderDate;
    private double orderTotal;

    // Constructors
    public Order() {
    }

    public Order(int orderId, int customerId, int shipmentId, String orderDate, double orderTotal) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.shipmentId = shipmentId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    // Getter and Setter methods
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
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
}
