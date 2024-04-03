package One;
public class Product_to_show {
    private int id;
    private String name;
    private String description;
    private int price;
    
    private String imageUrl;

    public Product_to_show(int id, String name, String description, String imageUrl,int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        
    }

    // Getter methods
    public int getprice() {
        return price;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
