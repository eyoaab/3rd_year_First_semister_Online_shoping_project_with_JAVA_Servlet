package One;
import java.io.Serializable;

public class Product1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private int productId;
    private String productName;
    private String productDescription;
    private double price;
    private String imageUrl;
    private int quantityInStock;
    private int categoryId;
    private String createdDate;

 
    public Product1() {
    }

    public Product1(int productId, String productName, String productDescription, double price, String imageUrl,
                   int quantityInStock, int categoryId, String createdDate) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.imageUrl = imageUrl;
        this.quantityInStock = quantityInStock;
        this.categoryId = categoryId;
        this.createdDate = createdDate;
    }

   
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
