package myShop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long id;
    @OneToOne(mappedBy = "basket")
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToMany(mappedBy = "basketList")
    private List<Product> productList;
    @Column(name = "quantity")
    private double quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Basket() {

    }


}
