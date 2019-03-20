package myShop.entity;


import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


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
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "basket_id"))
    private List<Basket> basketList;


    public void setId(long id) {
        this.id = id;
    }

    public List<Basket> getBasket() {
        return basketList;
    }

    public void setBasket(List<Basket> basket) {
        this.basketList = basket;
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", groupProduct=" + groupProduct +
                '}';
    }
}
//    @Column(name = "pictures")
//    private String pictures;
//    @Column(name = "descriptions")
//    private String descriptions;