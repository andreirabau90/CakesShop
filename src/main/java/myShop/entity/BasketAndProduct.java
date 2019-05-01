package myShop.entity;

import javax.persistence.*;

@Entity
@Table(name = "basket_product")
public class BasketAndProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketAndProduct_id")
    private Long basketAndProductId;
    @ManyToOne
    @JoinColumn(name = "ref_basketID")
    private Basket basket;
    @ManyToOne
    @JoinColumn(name = "ref_productID")
    private Product product;
    @Column(name = "quantity")
    private double quantity;

    public BasketAndProduct() {
    }

    public BasketAndProduct(Basket basket, Product product, double quantity) {
        this.basket = basket;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getBasketAndProductId() {

        return basketAndProductId;
    }

    public void setBasketAndProductId(Long basketAndProductId) {
        basketAndProductId = basketAndProductId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BasketAndProduct{" +
                "basketAndProductId=" + basketAndProductId +
                ", basket=" + basket +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
