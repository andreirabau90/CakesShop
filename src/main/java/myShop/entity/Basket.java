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
    @OneToOne(mappedBy = "basket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
    @OneToMany(mappedBy = "basket", fetch = FetchType.LAZY)
    private List<BasketAndProduct> basketAndProductList;

    public List<BasketAndProduct> getBasketAndProductList() {
        return basketAndProductList;
    }

    public void setBasketAndProductList(List<BasketAndProduct> basketAndProductList) {
        this.basketAndProductList = basketAndProductList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Basket() {

    }

}
