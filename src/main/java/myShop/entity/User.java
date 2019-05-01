package myShop.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @NotEmpty
    @Size(min = 3, max = 20, message = "количество символов от 3 до 20")
    @Column(name = "user_name")
    private String userName;
        @NotEmpty
    @Column(name = "user_pass")
    @Size(min = 8, max = 25, message = "количество символов от 8 до 25")
    private String pass;
    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "введите правильный email.")
    @Column(name = "user_email")
    private String email;
    @OneToMany(mappedBy = "feedbackUser")
    private List<Feedback> userFeedback;
    @OneToOne
    @JoinColumn(name = "user_basket")
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Feedback> getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(List<Feedback> userFeedback) {
        this.userFeedback = userFeedback;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String userName, String pass, String email, Basket basket) {
        this.userName = userName;
        this.pass = pass;
        this.email = email;
        this.basket = basket;
    }

    public User() {

    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
