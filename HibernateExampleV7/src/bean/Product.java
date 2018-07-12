package bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;


@Entity
@Table(name="PRODUCT")
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int productId;
    private String name;
    private String description;
    private String price;
    
    @ManyToOne
    private Supplier supplier;

    public Product() {
    }

    public Product(String name, String description, String price, Supplier supplier) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplier = supplier;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
    
    
}
