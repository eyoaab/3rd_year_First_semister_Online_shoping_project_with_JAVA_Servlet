package One;
import java.util.Date;

public class ProductReviewDetails {
    private String productName;
    private int rating;
    private Date reviewDate;
    private String reviewDescription;
    private String customerFirstName;
    private String customerLastName;
    private String email;

    // Constructors

    public ProductReviewDetails() {
    }

    public ProductReviewDetails(String productName, int rating, Date reviewDate, String reviewDescription,
                                String customerFirstName, String customerLastName, String email) {
        this.productName = productName;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.reviewDescription = reviewDescription;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.email = email;
    }

    // Getters and setters

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
