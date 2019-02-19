package myShop.Entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Controller
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;



    @ManyToOne
    @JoinColumn(name = "product_group")
    private GroupProduct groupProduct;
    @OneToMany(mappedBy = "feedbackProduct")
    private List<Feedback> productFeedback;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public GroupProduct getGroupProduct() {
        return groupProduct;
    }

    public void setGroupProduct(GroupProduct groupProduct) {
        this.groupProduct = groupProduct;
    }

    public List<Feedback> getProductFeedback() {
        return productFeedback;
    }

    public void setProductFeedback(List<Feedback> productFeedback) {
        this.productFeedback = productFeedback;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product() {

    }
}
//    @Column(name = "pictures")
//    private String pictures;
//    @Column(name = "descriptions")
//    private String descriptions;