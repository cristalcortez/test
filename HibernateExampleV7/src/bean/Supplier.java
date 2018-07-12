package bean;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
@Table(name="SUPPLIER")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int supplierId;
    
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="")
    private List<Product> products = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(String name) {
        this.name = name;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
    
}
