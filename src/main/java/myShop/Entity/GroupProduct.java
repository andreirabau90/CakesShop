package myShop.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_product")
public class GroupProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;
    @Column(name = "group_name")
    private String group;
    @OneToMany(mappedBy = "groupProduct", fetch = FetchType.LAZY)
    private List<Product> productList;

    @Override
    public String toString() {
        return "GroupProduct{" +
                "id=" + id +
                ", group='" + group + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public GroupProduct() {

    }


}
